package www.jointeams.com.QApp.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import www.jointeams.com.QApp.model.Chapter;
import www.jointeams.com.QApp.model.Course;
import www.jointeams.com.QApp.model.MultipleChoice;
import www.jointeams.com.QApp.model.Option;
import www.jointeams.com.QApp.model.ShortAnswer;
import www.jointeams.com.QApp.model.TrueFalse;
import www.jointeams.com.QApp.service.QuestionRegistration;

@ConversationScoped
@Named("CreateQuestion")
public class CreateQuestionController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MultipleChoice newQuestion;
	private TrueFalse newTrueFalse;
	private ShortAnswer newShortAnswer;
	private Integer assignAnswer;
	private boolean added = false;
	private boolean[] type;
	private int qtype;

	@Inject
	Conversation conversation;

	@Inject
	@Named("courseByOption")
	private List<Course> courses;

	@Inject
	QuestionRegistration qr;
	
	@Inject
	UserController userCon;

	public void startConversation() {
		if (conversation.isTransient()) {
			conversation.begin();
		}
	}

	@Produces
	@Named("getCourses")
	public List<Course> getCourses() {
		return courses;
	}

	/**
	 * need too link the chapters to the course that is selected.
	 * 
	 * @return
	 */
	public List<Chapter> getChapters() {
		if (newQuestion.getCourse() == null)
			return null;
		return newQuestion.getCourse().getChapters();
	}

	public void setAssignAnswer(Integer option) {
		if (option != 0) {
			newQuestion.setAnswer(newQuestion.getOptions().get(option - 1));
			assignAnswer = option;
		}
	}

	public Integer getAssignAnswer() {
		return assignAnswer;
	}

	@Produces
	@Named("newQuestion")
	public MultipleChoice getNewQuestion() {
		return newQuestion;
	}

	public String registerQuestion() {
		switch (qtype) {
		case 0:
			for (Option option : newQuestion.getOptions()) {
				option.setMultipleChoice(newQuestion);
			}
			newQuestion.setApproved(false);
			newQuestion.setAuthor(userCon.getCurrentUser());
			qr.registerMulti(newQuestion);
			break;
		case 1:
			newTrueFalse.setChapter(newQuestion.getChapter());
			newTrueFalse.setCourse(newQuestion.getCourse());
			newTrueFalse.setQuestion(newQuestion.getQuestion());
			newTrueFalse.setApproved(false);
			newTrueFalse.setAuthor(userCon.getCurrentUser());
			qr.registerTrueFalse(newTrueFalse);
			break;
		case 2:
			newShortAnswer.setChapter(newQuestion.getChapter());
			newShortAnswer.setCourse(newQuestion.getCourse());
			newShortAnswer.setQuestion(newQuestion.getQuestion());
			newShortAnswer.setApproved(false);
			newShortAnswer.setAuthor(userCon.getCurrentUser());
			qr.registerShortAnswer(newShortAnswer);
			break;
		}
		setAdded(true);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Successful",
				"Question Added"));
		if (!conversation.isTransient()) {
			conversation.end();
		}
		return "null";
	}

	@PostConstruct
	public void initQuestion() {
		newQuestion = new MultipleChoice();
		newTrueFalse = new TrueFalse();
		newShortAnswer = new ShortAnswer();
		List<Option> options = new ArrayList<Option>();
		setType(new boolean[4]);
		type[0] = true;
		for (int i = 0; i < 4; i++) {
			options.add(new Option());
		}
		((MultipleChoice) newQuestion).setOptions(options);
		startConversation();
	}

	public boolean isAdded() {
		return added;
	}

	public void setAdded(boolean added) {
		this.added = added;
	}

	public boolean[] getType() {
		return type;
	}

	public void setType(boolean[] type) {
		this.type = type;
	}

	public int getQtype() {
		return qtype;
	}

	public void setQtype(int qtype) {
		setType(new boolean[4]);
		type[qtype] = true;
		this.qtype = qtype;
	}

	public TrueFalse getNewTrueFalse() {
		return newTrueFalse;
	}

	public void setNewTrueFalse(TrueFalse newTrueFalse) {
		this.newTrueFalse = newTrueFalse;
	}

	public ShortAnswer getNewShortAnswer() {
		return newShortAnswer;
	}

	public void setNewShortAnswer(ShortAnswer newShortAnswer) {
		this.newShortAnswer = newShortAnswer;
	}

}
