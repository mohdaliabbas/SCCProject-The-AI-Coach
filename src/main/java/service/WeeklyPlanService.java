package service;

import entity.SkillGap;
import newentity.WeeklyPlan;
import repository.SkillGapRepository;
import repository.WeeklyPlanRepository;
import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class WeeklyPlanService {

	@Autowired
	private SkillGapRepository gaprepo;
	
	@Autowired
	private WeeklyPlanRepository planrepo;
	
	@Autowired
	private WeeklyPlannerService planner;
	
	public List<WeeklyPlan> generateweeklyplan(Long userid){
		List<SkillGap> gaps = gaprepo.findAll()
				.stream()
				.filter(g -> g.getUserId().equals(userid))
				.toList();
		
		List<WeeklyPlan> plan = planner.generatePlan(userid, gaps);
		
		return planrepo.saveAll(plan);
	}
	
}
