package www.jointeams.com.QApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Coding extends Question {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="Answer")
	private String answer;

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
