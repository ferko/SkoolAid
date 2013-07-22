package www.jointeams.com.QApp.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import www.jointeams.com.QApp.model.User;

@Stateless
public class UserAccess {

	@Inject
	private EntityManager em;

	public User findUserByName(String userName) {
		User user = null;
		user = em.find(User.class, userName);
		return user;
	}

	public List<User> getAllUsers() {
		List<User> users = null;

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> criteria = cb.createQuery(User.class);
		Root<User> user = criteria.from(User.class);
		criteria.select(user).orderBy(cb.asc(user.get("userName")));
		users = em.createQuery(criteria).getResultList();
		return users;
	}
}
