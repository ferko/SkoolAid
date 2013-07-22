package www.jointeams.com.QApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class TrueFalse extends Question{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="Boolean_answer")
	private Boolean answer;

	public Boolean getAnswer() {
		return answer;
	}

	public void setAnswer(Boolean answer) {
		this.answer = answer;
	}
}
