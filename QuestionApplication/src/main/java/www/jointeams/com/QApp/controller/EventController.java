package www.jointeams.com.QApp.controller;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.ScheduleEntrySelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

import www.jointeams.com.QApp.model.Course;
import www.jointeams.com.QApp.model.Event;
import www.jointeams.com.QApp.model.User;

@SessionScoped
@Named("EventController")
public class EventController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	@Named("currentUser")
	private User currentUser;
	private ScheduleModel eventModel;
	private Event event;

	public EventController() {
	}

	@PostConstruct
	public void initEventController()
	{
		eventModel = new DefaultScheduleModel();
		for (Course course : currentUser.getCourseOption().getCourses()) {
			for (Event event : course.getEvents()) {
				try {
					DefaultScheduleEvent defaultEvent = new DefaultScheduleEvent(course
							.getCourseName(), new SimpleDateFormat("MM/dd/yy")
							.parse(event.getDate()), new SimpleDateFormat(
							"MM/dd/yy").parse(event.getDate()), event);	
					eventModel.addEvent(defaultEvent);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void onEventSelect(ScheduleEntrySelectEvent selectEvent) {
		event = (Event) selectEvent.getScheduleEvent().getData();
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}


}
