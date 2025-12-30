package Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.project.dto.ApiResponse;

import service.AiAssistService;
@RestController
@RequestMapping("/api")
public class CareerCoachController {

	private final AiAssistService aiassist;
	
	public CareerCoachController(AiAssistService aiassist) {
		this.aiassist=aiassist;
	}
	
	@GetMapping("/ai/explain/{skill}")
//	public String explainSkillGap(@PathVariable String skill) {
//		return aiassist.explainGap(skill);
//	}
	public ApiResponse<String> explainSkill(@PathVariable String skill){
		return new ApiResponse<>(aiassist.explainGap(skill),"Ai response");
	}
	
}
