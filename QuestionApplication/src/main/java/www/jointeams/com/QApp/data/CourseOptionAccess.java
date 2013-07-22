package www.jointeams.com.QApp.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import www.jointeams.com.QApp.model.CourseOption;

@Stateless
public class CourseOptionAccess {

	@Inject
	private EntityManager em;	
	public List<CourseOption> getCourseOptions()
	{
		
		TypedQuery<CourseOption> query = em.createQuery("select co from CourseOption co", CourseOption.class);
		List<CourseOption> newList = query.getResultList();
		return newList;
	}
}
