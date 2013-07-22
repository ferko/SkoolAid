package www.jointeams.com.QApp.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import www.jointeams.com.QApp.service.RecoveryRegistration;

@Named("PasswordRecovery")
@RequestScoped
public class PasswordRecoveryController {

	@Inject
	RecoveryRegistration recReg;
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String recover()
	{
		if(recReg.register(email))
		{
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Successful",
				"Email has been sents"));
		}
		else
		{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Failure",
					"Email doesnt exist"));
		}
		return "";
	}
	
}
