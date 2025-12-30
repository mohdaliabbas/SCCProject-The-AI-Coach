package Controller;
import com.demo.project.dto.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

//import com.demo.project.dto.ApiResponse;

import newentity.WeeklyPlan;
import repository.WeeklyPlanRepository;

//import java.awt.PageAttributes.MediaType;
import org.springframework.http.MediaType;

import java.util.*;
import service.WeeklyPlanService;
import service.WeeklyPlannerService;
@RestController
@RequestMapping("/api")
public class WeeklyController {

	@Autowired
	private WeeklyPlanService weeklyPlanService;
//	
	@Autowired
	private WeeklyPlanRepository weeklyPlanRepository;

//	@PostMapping("/plan/generate/{userid}")
//	public ApiResponse<List<WeeklyPlan>> generatePlan(@PathVariable Long userid){
//		List<WeeklyPlan> plan=weeklyPlanService.generateweeklyplan(userid);
//		
//		return new ApiResponse<>(plan, "Plan generated successfully");
//	}
//	
	@PostMapping("/plan/generate/{userid}")
	public ApiResponse<List<WeeklyPlan>> generatePlan(@PathVariable Long userid) {
	    List<WeeklyPlan> plan = weeklyPlanService.generateweeklyplan(userid);
	    return new ApiResponse<>(plan, "Plan generated successfully");
	}

	@GetMapping("/plan/{userid}")
	public List<WeeklyPlan> viewPlan(@PathVariable Long userid){
		return weeklyPlanRepository.findByUserId(userid);
	}
}
