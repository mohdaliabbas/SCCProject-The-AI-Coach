package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import newentity.InterviewQuestion;
//import 

public interface InterviewQuestionRepository extends JpaRepository<InterviewQuestion, Long> {

		List<InterviewQuestion> findBySkill(String skill);
}
