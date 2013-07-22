package www.jointeams.com.QApp.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import www.jointeams.com.QApp.model.Question;

@Stateless
public class QuestionAccess {
	@Inject
	private EntityManager em;

	public List<Question> getQuestions(String courseId, int chapterId) {
		TypedQuery<Question> query = em.createQuery(
				"select m from Question m where Course_id = \'"
						+ courseId + "\' and Chapter_ID = \'" + chapterId
						+ "\' and Approved = true", Question.class);
		List<Question> newList = query.getResultList();
		return newList;
	}
	
	public List<Question> getNotApproved() {
		TypedQuery<Question> query = em.createQuery(
				"select q from Question q where Approved = false", Question.class);
		List<Question> newList = query.getResultList();
		return newList;
	}
}
