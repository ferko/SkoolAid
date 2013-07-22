package www.jointeams.com.QApp.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import www.jointeams.com.QApp.data.QuestionAccess;
import www.jointeams.com.QApp.model.MultipleChoice;
import www.jointeams.com.QApp.model.Option;
import www.jointeams.com.QApp.model.Question;
import www.jointeams.com.QApp.model.ShortAnswer;
import www.jointeams.com.QApp.model.TrueFalse;
import www.jointeams.com.QApp.service.QuestionRegistration;


/**
 * This class is class is used to retrieve questions waiting for approval, it allows the questions
 * to be edited if needed and then update into the database or deleted.
 * 
 * @author Frank Berenyi
 *
 */
@Named("ApproveQuestion")
@ConversationScoped
public class ApproveQuestionController implements Serializable {

	/**
	 * Serializable Id
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Conversation used to start and stop the scope
	 */
	@Inject
	private Conversation conversation;
	
	/**
	 * QuestionAccess is the class used to retrieve questions from the datasource
	 */
	@Inject
	private QuestionAccess qa;
	
	/**
	 * QuestionRegistation the the class used to persist, update and delete questions
	 */
	@Inject
	QuestionRegistration qr;
	
	/**
	 * List of multiple choice questions waiting for approval
	 */
	private List<MultipleChoice> multipleChoice;
	
	/**
	 * List of true false questions waiting for approval
	 */
	private List<TrueFalse> trueFalse;
	
	/**
	 * List of short answer questions waiting for approval
	 */
	private List<ShortAnswer> shortAnswers;
	
	/**
	 * Array of booleans used to indicate which multiple choice question is being
	 * edited
	 */
	private boolean[] editMultipleChoice;
	
	/**
	 * Array of booleans used to indicate which true false question is being
	 * edited
	 */
	private boolean[] editTrueFalse;
	
	/**
	 * Array of booleans used to indicate which short answer question is being
	 * edited
	 */
	private boolean[] editShortAnswer;
	
	/**
	 * Boolean used to indicate that a question is being edited and that some
	 * items in the view wont be rendered while this is happening
	 */
	private boolean editing;

	/**
	 * This method gets all the questions waiting approval and then it puts the 
	 * into the List which corresponds to the type of the question. it then
	 * creates the boolean arrays with the size of the question Lists.  This
	 * method is called in the post construction of this class
	 */
	public void getQuestions() {
		List<Question> questions;
		questions = qa.getNotApproved();
		for (Question question : questions) {
				if (question instanceof MultipleChoice) {
					multipleChoice.add((MultipleChoice) question);
				} else if (question instanceof TrueFalse) {
					trueFalse.add((TrueFalse) question);
				} else if (question instanceof ShortAnswer) {
					shortAnswers.add((ShortAnswer) question);
				}
		}
		editMultipleChoice = new boolean[multipleChoice.size()];
		editTrueFalse = new boolean[trueFalse.size()];
		editShortAnswer = new boolean[shortAnswers.size()];
	}

	/**
	 * Getter for the List of true false questions
	 * 
	 * @return List of true false questions
	 */
	public List<TrueFalse> getTrueFalse() {
		return trueFalse;
	}

	/**
	 * Getter for the List of short answer questions
	 * 
	 * @return List of short answer questions
	 */
	public List<ShortAnswer> getShortAnswers() {
		return shortAnswers;
	}

	/**
	 * Getter for the List of multiple choice questions
	 * 
	 * @return List of multiple choice questions
	 */
	public List<MultipleChoice> getMultipleChoice() {
		return multipleChoice;
	}

	/**
	 * This method is called upon form submition. The questions
	 * are sent to the QuestionRegistration class so that they
	 * can be merged into the data source and also deleted.
	 * Conversation is ended and then redirects to the welcome
	 * page  
	 * 
	 * @return String indicated to redirct to welcome page
	 */
	public String approve() {
		qr.updateTrueFalse(trueFalse);
		qr.updateMultipleChoice(multipleChoice);
		qr.updateShortAnswer(shortAnswers);
		if (!conversation.isTransient()) {
			conversation.end();
		}
		return "welcome";
	}
	
	/**
	 * Getter for the boolean editing used to indicate if the user is
	 * editing
	 * 
	 * @return statues of editing
	 */
	public boolean isEditing() {
		return editing;
	}

	/**
	 * Used to set the statues of editing to indicate that the user is
	 * editing a question
	 * 
	 * @param editing new statues of editing
	 */
	public void setEditing(boolean editing) {
		this.editing = editing;
	}

	/**
	 * This method is called in the view to find out if the the style
	 * class needs to be regular, green or red depending on the multiple
	 * choice answer that the user submitted
	 * 
	 * @param option to check against
	 * @return the styleClass used on the field
	 */
	public String getStyleClass(Option option) {
		for (MultipleChoice question : multipleChoice) {
			if (question.getAnswer().getOptionId() == option.getOptionId()) {
				return "correct";
			}
		}
		return "fields";
	}

	/**
	 * This method saves the multiple choice question after
	 * it has been edited.
	 * 
	 * @param index of the question being edited
	 * @return null
	 */
	public String saveMultipleChoice(int index) {
		editing = false;
		editMultipleChoice[index] = false;
		return "";
	}

	/**
	 * This method is used to start editing a multiple choice
	 * question.  A conversation is started when this happens
	 * 
	 * @param index of the question to be edited
	 * @return null
	 */
	public String editingMultipleChoice(int index) {
		if (conversation.isTransient()) {
			conversation.begin();
		}
		editing = true;
		editMultipleChoice[index] = true;
		return "";
	}
	
	/**
	 * This method is used to save the true false question
	 * being edited.
	 * 
	 * @param index of the question being saved
	 * @return null
	 */
	public String saveTrueFalse(int index) {
		editing = false;
		editTrueFalse[index] = false;
		return "";
	}

	/**
	 * This method is used to edit the true false question
	 * and the conversation is started
	 * 
	 * @param index of the question to be edited
	 * @return null
	 */
	public String editingTrueFalse(int index) {
		if (conversation.isTransient()) {
			conversation.begin();
		}
		editing = true;
		editTrueFalse[index] = true;
		return "";
	}
	
	/**
	 * This method is called to save the short answer question
	 * that is being edited.
	 * 
	 * @param index of the question being saved
	 * @return null
	 */
	public String saveShortAnswer(int index) {
		editing = false;
		editShortAnswer[index] = false;
		return "";
	}

	/**
	 * This method is used to start editing a short 
	 * answer question
	 * 
	 * @param index of the question to be edited
	 * @return null
	 */
	public String editingShortAnswer(int index) {
		if (conversation.isTransient()) {
			conversation.begin();
		}
		editing = true;
		editShortAnswer[index] = true;
		return "";
	}
	
	/**
	 * This method is called post construct the class and it
	 * is used to instantsiated the lists used to hold the questions
	 * and also calls the method to retrieve the questions needing
	 * approval
	 */
	@PostConstruct
	public void initApproveQuestions() {
		multipleChoice = new ArrayList<MultipleChoice>();
		trueFalse = new ArrayList<TrueFalse>();
		shortAnswers = new ArrayList<ShortAnswer>();
		getQuestions();
	}

	/**
	 * Get the statues of the true false question being edited
	 * 
	 * @return statues of the question
	 */
	public boolean[] getEditTrueFalse() {
		return editTrueFalse;
	}

	/**
	 * Set the statues of the the question to be edited 
	 * or reset
	 * 
	 * @param editTrueFalse
	 */
	public void setEditTrueFalse(boolean[] editTrueFalse) {
		this.editTrueFalse = editTrueFalse;
	}

	/**
	 * Get the statues of the short answer question being edited
	 * 
	 * @return array of statueses
	 */
	public boolean[] getEditShortAnswer() {
		return editShortAnswer;
	}

	/**
	 * Set the statues of the short answer questions
	 * 
	 * @param editShortAnswer new array
	 */
	public void setEditShortAnswer(boolean[] editShortAnswer) {
		this.editShortAnswer = editShortAnswer;
	}

	/**
	 * Get the statues of the multiple choice question being edited
	 * 
	 * @return array of statues'
	 */
	public boolean[] getEditMultipleChoice() {
		return editMultipleChoice;
	}

	/**
	 * Set the array of multiple choice statues'
	 * 
	 * @param editMultipleChoice new array
	 */
	public void setEditMultipleChoice(boolean[] editMultipleChoice) {
		this.editMultipleChoice = editMultipleChoice;
	}
}
