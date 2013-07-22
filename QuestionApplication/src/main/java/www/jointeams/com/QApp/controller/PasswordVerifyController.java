package www.jointeams.com.QApp.controller;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import www.jointeams.com.QApp.model.PasswordRecover;
import www.jointeams.com.QApp.util.SHAHash;

@ConversationScoped
@Named("PasswordVerify")
public class PasswordVerifyController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager em;
	@Inject
	Conversation conversation;
	@Resource
	private UserTransaction utx;
	private String id;
	private PasswordRecover passRec;
	private String password;
	private boolean display;

	public void verifyLink(ComponentSystemEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		id = (String) facesContext.getExternalContext()
				.getRequestParameterMap().get("id");
		if (id == null || id.trim().equals("")) {
			id = "nothing";
		}
		passRec = em.find(PasswordRecover.class, id);
		if (passRec != null) {
			setDisplay(true);
			if (conversation.isTransient()) {
				conversation.begin();
			}
		} else {
			setDisplay(false);
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

	public String submit() {

		try {
			utx.begin();
			passRec.getUser().setPassword(
					SHAHash.hash(password, passRec.getUser().getUserName()));
			em.merge(passRec.getUser());
			passRec = em.find(PasswordRecover.class, passRec.getEmailID());
			if (passRec != null) {
				em.remove(passRec);
			}
			utx.commit();
			if (!conversation.isTransient()) {
				conversation.end();
			}
		} catch (NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "login";
	}

	public String home() {
		if (!conversation.isTransient()) {
			conversation.end();
		}
		return "login";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}