package www.jointeams.com.QApp.controller;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
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

import www.jointeams.com.QApp.model.EmailLink;

@RequestScoped
@Named("EmailVerify")
public class EmailVerification implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager em;
	@Resource
	private UserTransaction utx;
	private String id;
	private EmailLink emailLink;
	private String message;

	public void verifyLink(ComponentSystemEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		id = (String) facesContext.getExternalContext()
				.getRequestParameterMap().get("id");
		if(id == null || id.trim().equals(""))
		{
			id = "nothing";
		}
		try {
			utx.begin();
			emailLink = em.find(EmailLink.class, id);
			if (emailLink != null) {
				emailLink.getUser().setRole("USER");
				em.merge(emailLink);
				em.remove(emailLink);
				utx.commit();
				setMessage("Account is now active, proceeed to login");
			} else {
				utx.rollback();
				setMessage("Activation Link does not exist");
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

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}