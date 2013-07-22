package www.jointeams.com.QApp.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import www.jointeams.com.QApp.model.PasswordRecover;
import www.jointeams.com.QApp.model.User;
import www.jointeams.com.QApp.util.EmailSender;
import www.jointeams.com.QApp.util.RecoveryEmail;
import www.jointeams.com.QApp.util.SHAHash;

@Stateless
public class RecoveryRegistration {

	@Inject
	private EntityManager em;

	public boolean register(String email) {
		TypedQuery<User> query = em.createQuery(
				"select u from User u where Email =:emailparam",
				User.class);
		query.setParameter("emailparam", email.trim());
		List<User> users = query.getResultList();

		if (users.size() > 0) {
			String emailID = SHAHash.hash("93D83",
					SHAHash.hash("D38D0", users.get(0).getUserName()));
			PasswordRecover passrec = new PasswordRecover();
			passrec.setUser(users.get(0));
			passrec.setEmailID(emailID);
			EmailSender smtpMailSender = new EmailSender();
			try {
				ArrayList<String> recipiants = new ArrayList<String>();
				recipiants.add(users.get(0).getEmail());
				smtpMailSender.postMail(recipiants,
						"Password Recovery Skoolaid.ca",
						RecoveryEmail.getMsg(emailID, users.get(0).getUserName()), "info@skoolaid.ca");
			} catch (AuthenticationFailedException e) {
				e.printStackTrace();
				System.out.println("Error: " + e.getMessage());
				return false;
			} catch (MessagingException e) {
				e.printStackTrace();
				System.out.println("Error: " + e.getMessage());
				return false;
			}
			if(em.find(PasswordRecover.class, emailID) == null)
			{
				em.persist(passrec);
			}
			return true;
		}
		return false;
	}

}
