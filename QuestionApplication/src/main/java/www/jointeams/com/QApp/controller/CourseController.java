package www.jointeams.com.QApp.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import www.jointeams.com.QApp.model.Course;
import www.jointeams.com.QApp.model.User;

@RequestScoped
@Named("CourseController")
public class CourseController {
	
	@Inject @Named("currentUser")
	private User user;
	
	@Produces
	@Named("courseByOption")
	public List<Course> getCoursesByOption()
	{
		return user.getCourseOption().getCourses();
	}
}
