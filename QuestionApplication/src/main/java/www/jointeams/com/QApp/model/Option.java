package www.jointeams.com.QApp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Question_Options")
public class Option implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Option_ID")
	private int optionId;
	@Column(name="Option_text")
	private String option;
	@ManyToOne
	@JoinColumn(name="Question_ID")
	private MultipleChoice multipleChoice;
	
	public int getOptionId() {
		return optionId;
	}
	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public MultipleChoice getMultipleChoice() {
		return multipleChoice;
	}
	public void setMultipleChoice(MultipleChoice multipleChoice) {
		this.multipleChoice = multipleChoice;
	}
}
