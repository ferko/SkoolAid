package www.jointeams.com.QApp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="User_name")
	private String userName;
	@Column(name="Password")
	private String password;
	@Column(name="Email")
	private String email;
	@Column(name="Role")
	private String role;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="Course_Option")
	private CourseOption courseOption;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public CourseOption getCourseOption() {
		return courseOption;
	}
	public void setCourseOption(CourseOption courseOption) {
		this.courseOption = courseOption;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
