package www.jointeams.com.QApp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Question")
@Inheritance
@DiscriminatorColumn(name="Type")
public abstract class Question implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="Question")
	private String question;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Question_ID")
	private int questionId;
	@Column(name="Approved")
	private boolean approved;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="Course_ID")
	private Course course;
	@OneToOne
	@JoinColumn(name="Chapter_ID")
	private Chapter chapter;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Author_ID")
	private User author;
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Chapter getChapter() {
		return chapter;
	}
	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	
}
