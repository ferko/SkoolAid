package www.jointeams.com.QApp.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import www.jointeams.com.QApp.data.QuestionAccess;
import www.jointeams.com.QApp.model.Chapter;
import www.jointeams.com.QApp.model.Course;
import www.jointeams.com.QApp.model.MultipleChoice;
import www.jointeams.com.QApp.model.Option;
import www.jointeams.com.QApp.model.Question;
import www.jointeams.com.QApp.model.ShortAnswer;
import www.jointeams.com.QApp.model.TrueFalse;

@ConversationScoped
@Named("Quiz")
public class QuizController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Course course;
	private Chapter chapter;
	private List<Option> answers;
	private List<Boolean> trueFalseAnswers;
	private List<String> shortAnswerAnswers;
	@Inject
	Conversation conversation;

	@Inject
	@Named("courseByOption")
	private List<Course> courses;

	@Inject
	private QuestionAccess qa;

	private int score = 0;
	private boolean submitted;
	private List<MultipleChoice> questions;
	private List<TrueFalse> trueFalse;
	private List<ShortAnswer> shortAnswer;
	
	public void startConversation() {
		if (conversation.isTransient()) {
			conversation.begin();
		}
	}

	public List<Course> getCourses() {
		return courses;
	}

	/**
	 * need too link the chapters to the course that is selected.
	 * 
	 * @return
	 */
	@Produces
	@Named("quizChapters")
	public List<Chapter> getChapters() {
		if (course == null)
			return null;
		return course.getChapters();
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Chapter getChapter() {
		return chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

	public List<MultipleChoice> getQuestions() {
		return questions;
	}

	public void setQuestions(List<MultipleChoice> questions) {
		this.questions = questions;
	}

	public List<Option> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Option> answers) {
		this.answers = answers;
	}

	public String getStyleClass(Option option) {
		if (submitted) {
			for (MultipleChoice question : questions) {
				if (question.getAnswer().getOptionId() == option.getOptionId()) {
					return "correct";
				}
			}
			for (Option submittedValue : answers) {
				if (submittedValue.getOptionId() == option.getOptionId()) {
					return "incorrect";
				}
			}
		}
		return "fields";
	}
	
	public String getTrueFalseStyleClass(Integer index) {
		if (submitted) {
			if(trueFalse.get(index).getAnswer() == trueFalseAnswers.get(index))
				return "correct";
		}
		return "incorrect";
	}

	public String getResult() {
		for (MultipleChoice question : questions) {
			for (Option submittedValue : answers) {
				if (submittedValue.getOptionId() == question.getAnswer()
						.getOptionId()) {
					score++;
				}
			}
		}
		for(int i=0; i < trueFalse.size(); i++)
		{
			System.out.println(trueFalseAnswers.get(i));
			if(trueFalse.get(i).getAnswer() == trueFalseAnswers.get(i))
			{
				score++;
			}
		}
		submitted = true;
		endConversation();
		return "";
	}

	public String initQuestion() {
		
		
		List<Question> temp;
		temp = qa.getQuestions(course.getCourseId(),
				chapter.getChapterId());
		questions = new ArrayList<MultipleChoice>();
		trueFalse = new ArrayList<TrueFalse>();
		shortAnswer = new ArrayList<ShortAnswer>();
		
		for (Question question : temp) {
				if (question instanceof MultipleChoice) {
					questions.add((MultipleChoice) question);
				} else if (question instanceof TrueFalse) {
					trueFalse.add((TrueFalse) question);
				} else if (question instanceof ShortAnswer) {
					shortAnswer.add((ShortAnswer) question);
				}
		}	
			
		answers = new ArrayList<Option>();
		for (int i = 0; i < questions.size(); i++) {
			answers.add(new Option());
		}
		shortAnswerAnswers = new ArrayList<String>();
		for (int i = 0; i < shortAnswer.size(); i++) {
			shortAnswerAnswers.add(new String());
		}
		trueFalseAnswers = new ArrayList<Boolean>();
		for (int i = 0; i < trueFalse.size(); i++) {
			trueFalseAnswers.add(new Boolean(false));
		}
		submitted = false;
		return "takequiz";
	}

	public void endConversation() {
		if (!conversation.isTransient() && submitted) {
			conversation.end();
		}
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isSubmitted() {
		return submitted;
	}

	public void setSubmitted(boolean submitted) {
		this.submitted = submitted;
	}

	public List<TrueFalse> getTrueFalse() {
		return trueFalse;
	}

	public void setTrueFalse(List<TrueFalse> trueFalse) {
		this.trueFalse = trueFalse;
	}

	public List<ShortAnswer> getShortAnswer() {
		return shortAnswer;
	}

	public void setShortAnswer(List<ShortAnswer> shortAnswer) {
		this.shortAnswer = shortAnswer;
	}

	public List<Boolean> getTrueFalseAnswers() {
		return trueFalseAnswers;
	}

	public void setTrueFalseAnswers(List<Boolean> trueFalseAnswers) {
		this.trueFalseAnswers = trueFalseAnswers;
	}

	public List<String> getShortAnswerAnswers() {
		return shortAnswerAnswers;
	}

	public void setShortAnswerAnswers(List<String> shortAnswerAnswers) {
		this.shortAnswerAnswers = shortAnswerAnswers;
	}
	
}
