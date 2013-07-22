package www.jointeams.com.QApp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="Courses")
public class Course implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="Course_ID")
	private String courseId;
	@Column(name="Course_name")
	private String courseName;
	@Column(name="Instructor")
	private String Instructor;
	@OneToMany(mappedBy="course")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Event> events;
	@ManyToMany(mappedBy="courses")
	private List<CourseOption> courseOptions;
	@OneToMany(mappedBy="course")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Chapter> chapters;
	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getInstructor() {
		return Instructor;
	}
	public void setInstructor(String instructor) {
		Instructor = instructor;
	}
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	public List<CourseOption> getCourseOptions() {
		return courseOptions;
	}
	public void setCourseOptions(List<CourseOption> courseOptions) {
		this.courseOptions = courseOptions;
	}
	public List<Chapter> getChapters() {
		return chapters;
	}
	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}
	
}
