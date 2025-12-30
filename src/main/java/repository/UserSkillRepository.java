package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.UserSkill;

public interface UserSkillRepository extends JpaRepository<UserSkill, Long>{
	
	List<UserSkill> findByUserId(Long userid);
	
}
