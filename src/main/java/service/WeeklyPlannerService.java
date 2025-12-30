package service;

import org.springframework.stereotype.Service;
import entity.SkillGap;
import newentity.WeeklyPlan;
import Priority.Priority;
import java.util.*;

@Service
public class WeeklyPlannerService {

	public static final String[] Days= {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
	
	// Comparator to sort by priority: HIGH > MEDIUM > LOW
	private static final Comparator<Priority> PRIORITY_COMPARATOR = (p1, p2) -> {
		Map<Priority, Integer> priorityOrder = Map.of(Priority.HIGH, 1, Priority.MEDIUM, 2, Priority.LOW, 3);
		return priorityOrder.get(p1).compareTo(priorityOrder.get(p2));
	};
	
	public List<WeeklyPlan> generatePlan(Long Userid,List<SkillGap> gaps){
		List<WeeklyPlan> plan=new ArrayList<>();
		int dayIndex=0;
		List<SkillGap> sortedgaps=gaps.stream()
				.sorted(Comparator.comparing(SkillGap::getPriority, PRIORITY_COMPARATOR))
				.toList();
		
		for(SkillGap gap: sortedgaps) {
			if(dayIndex>=Days.length) {
				break;
			}
			WeeklyPlan wp=new WeeklyPlan();
			wp.setUserId(Userid);
	
			wp.setDay(Days[dayIndex++]);
			wp.setTask(createTask(gap));
			plan.add(wp);
		}
		return plan;
		
	}
	private String createTask(SkillGap gap) {
		String skillName = gap.getSkillName();
		return switch(skillName) {
		case "DSA" -> "solve 5 medium DSA problems +revise concepts";
		case "Core Java", "core Java" -> "Revise OOP,Collections,Streams";
		case "System Design" -> "Build one Rest API with validation";
		default -> "Improve " + skillName;
		};
	}
}
