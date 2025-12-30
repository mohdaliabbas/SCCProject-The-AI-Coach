package service;

import org.springframework.stereotype.Service;

import java.util.*;

import entity.SkillGap;
import entity.UserProfile;
import entity.UserSkill;
import Priority.Priority;

@Service
public class CareerRuleEngine {
	
	public List<SkillGap> analyze(UserProfile profile, List<UserSkill> skills){
		List<SkillGap> gaps=new ArrayList<>();
		
		if(profile.getExpYears()<2) {
			gaps.add(createGap(profile.getId(),"DSA",Priority.HIGH));
			gaps.add(createGap(profile.getId(),"Core Java",Priority.HIGH));
			
	}
		if("ProductCompany".equalsIgnoreCase(profile.getTargetRole())){
			gaps.add(createGap(profile.getId(),"System Design",Priority.HIGH));
		}
		boolean hasSpring=skills.stream()
		.anyMatch(s->s.getSkillName().equalsIgnoreCase("Spring Boot"));
		
		if(!hasSpring) {
			gaps.add(createGap(profile.getId(),"Spring Boot",Priority.MEDIUM));
		}
		return gaps;
}
	private SkillGap createGap(Long userid,String skill, Priority priority) {
		SkillGap gap=new SkillGap();
		gap.setUserId(userid);
		gap.setSkillName(skill);
		gap.setPriority(priority);
		return gap;
	}
}
