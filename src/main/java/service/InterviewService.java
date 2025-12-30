package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import newentity.InterviewQuestion;
import repository.InterviewQuestionRepository;

@Service
public class InterviewService {
	
	@Autowired
	private InterviewQuestionRepository repo;
	
	public int evaluateanswer(Long questionId,String answer) {
		InterviewQuestion q=repo.findById(questionId).orElseThrow(()->new RuntimeException("Question not found"));
		String[] keys=q.getKeywords().split(",");
		int score=0;
		
		for(String key:keys) {
			if(answer.toLowerCase().contains(key.trim())) {
				score+=10;
			}
		}
		return score;
		
	}
}
