package newentity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
@Entity
//@Data
public class InterviewQuestion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String skill;
	@Column(name="question")
	private String question;
	
	@Column(name="keywords")
	private String keywords;
	
	public String getKeywords() {
		return keywords;
	}
	
	public void setKeywords(String keywords) {
	    this.keywords = keywords;
	}
	public String getQuestion() {
	    return question;
	}
	public void setQuestion(String question) {
	    this.question = question;
	}


}
