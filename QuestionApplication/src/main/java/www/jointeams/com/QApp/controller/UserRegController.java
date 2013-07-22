package www.jointeams.com.QApp.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import www.jointeams.com.QApp.data.CourseOptionAccess;
import www.jointeams.com.QApp.model.CourseOption;
import www.jointeams.com.QApp.model.User;
import www.jointeams.com.QApp.service.UserRegistration;
import www.jointeams.com.QApp.util.SHAHash;

@RequestScoped
@Named("UserReg")
public class UserRegController {

	private User newUser;
	@Inject
	private UserRegistration userRegistrator;
	@Inject
	private CourseOptionAccess courseOptAccess;
	private String password;
	private List<CourseOption> courseOptions;

	@Produces
	@Named("NewUser")
	public User getNewUser() {
		return newUser;
	}

	public List<CourseOption> getCourseOptions() {
		if (courseOptions == null) {
			courseOptions = courseOptAccess.getCourseOptions();
		}
		return courseOptions;
	}

	public String registerUser() {
		newUser.setPassword(SHAHash.hash(newUser.getPassword(), newUser.getUserName()));
		newUser.setRole("NEW");
		FacesMessage msg;
		if (userRegistrator.register(newUser)) {
			FacesContext context = FacesContext.getCurrentInstance();
			msg = new FacesMessage("Successfully Added",
					"Please check your email for the confirmation message");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			context.addMessage(null, msg);
			return null;
		}
		msg = new FacesMessage("Error",
				"Registration failed");
		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		System.out.println("Error: Register equals null");
		return null;
	}

	@PostConstruct
	public void initNewMember() {
		newUser = new User();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
