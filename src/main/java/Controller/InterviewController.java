package Controller;

import  java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.UserSkill;
import newentity.InterviewQuestion;
import repository.InterviewQuestionRepository;
import service.InterviewService;

@RestController
@RequestMapping("/api")
public class InterviewController {
	@Autowired
	private InterviewQuestionRepository intrepo;
	
	@Autowired
	private InterviewService intserv;
	
	@Autowired
	private CareerController carcon;
	
	@GetMapping("/interview/{skill}")
	public List<InterviewQuestion> getQuestions(@PathVariable String skill){
		return intrepo.findBySkill(skill);
	}
	

	
	@PostMapping("/interview/evaluate/{questionId}")
	public int evaluate(@PathVariable Long questionId,@RequestBody String answer) {
		return  intserv.evaluateanswer(questionId,answer);
		
	}
		
	
}
