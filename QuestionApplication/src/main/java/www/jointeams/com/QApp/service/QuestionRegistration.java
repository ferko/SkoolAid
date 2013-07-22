package www.jointeams.com.QApp.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import www.jointeams.com.QApp.model.MultipleChoice;
import www.jointeams.com.QApp.model.Option;
import www.jointeams.com.QApp.model.ShortAnswer;
import www.jointeams.com.QApp.model.TrueFalse;

@Stateless
public class QuestionRegistration {

	@Inject
	private EntityManager em;

	public void registerMulti(MultipleChoice question) {

		for (Option option : question.getOptions()) {
			em.persist(option);
		}
		em.persist(question);
	}

	public void registerTrueFalse(TrueFalse question) {
		em.persist(question);
	}
	
	public void registerShortAnswer(ShortAnswer question) {
		em.persist(question);
	}

	public void updateMultipleChoice(List<MultipleChoice> questions) {
		for (MultipleChoice question : questions) {
			if (question.isApproved()) {
				em.merge(question);
			} else {
				em.remove(em.find(MultipleChoice.class,
						question.getQuestionId()));
			}
		}
	}
	public void updateShortAnswer(List<ShortAnswer> questions) {
		for (ShortAnswer question : questions) {
			if (question.isApproved()) {
				em.merge(question);
			} else {
				em.remove(em.find(ShortAnswer.class,
						question.getQuestionId()));
			}
		}
	}
	public void updateTrueFalse(List<TrueFalse> questions) {
		for (TrueFalse question : questions) {
			if (question.isApproved()) {
				em.merge(question);
			} else {
				em.remove(em.find(TrueFalse.class,
						question.getQuestionId()));
			}
		}
	}
}
