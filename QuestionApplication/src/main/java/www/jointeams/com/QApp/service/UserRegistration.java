package www.jointeams.com.QApp.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;
import javax.persistence.EntityManager;

import www.jointeams.com.QApp.model.EmailLink;
import www.jointeams.com.QApp.model.User;
import www.jointeams.com.QApp.util.EmailSender;
import www.jointeams.com.QApp.util.RegistrationEmail;
import www.jointeams.com.QApp.util.SHAHash;

@Stateless
public class UserRegistration {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;
	
	public boolean register(User user) {
		if (em.find(User.class, user.getUserName()) == null) {
			String emailID = SHAHash.hash("93D83", SHAHash.hash("D38D0", user.getUserName()));
			log.info("Registering " + user.getUserName());
			EmailLink emailLink = new EmailLink();
			emailLink.setUser(user);
			emailLink.setEmailID(emailID);
			EmailSender smtpMailSender = new EmailSender();
		    try {
		    	ArrayList<String> recipiants = new ArrayList<String>();
		    	recipiants.add(user.getEmail());
				smtpMailSender.postMail( recipiants, "Confirmation Skoolaid.ca" , RegistrationEmail.getMsg(emailID) , "info@skoolaid.ca");
		    } catch (AuthenticationFailedException e) {
				e.printStackTrace();
				System.out.println("Error: " + e.getMessage());
				return false;
		    } catch (MessagingException e) {
				e.printStackTrace();
				System.out.println("Error: " + e.getMessage());
				return false;
			}
			em.persist(emailLink);
			return true;
		}
		return false;
	}
	
}
