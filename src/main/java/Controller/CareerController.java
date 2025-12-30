package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entity.SkillGap;
import entity.UserProfile;
import entity.UserSkill;
import repository.UserProfileRepository;
import repository.UserSkillRepository;
import service.CareerAnalysisService;
import java.util.*;

@RestController
@RequestMapping("/api")
public class CareerController {

	
	@Autowired
	private UserProfileRepository userprofilerepo;
	
	@Autowired
	private UserSkillRepository skillrepo;
	
	@Autowired
	private CareerAnalysisService analysisService;
	
	@PostMapping("/profile")
	public ResponseEntity<?> createprofile(@RequestBody UserProfile profile)
	{
		try {
			// Ignore ID if provided - let database generate it
			profile.setId(null);
			UserProfile savedProfile = userprofilerepo.save(profile);
			return ResponseEntity.ok(savedProfile);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("Error creating profile: " + e.getMessage() + " - " + e.getClass().getName());
		}
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception e) {
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
			.body("Error: " + e.getMessage() + " - " + e.getClass().getName());
	}
	
    @GetMapping("/profile")
    public List<UserProfile> getProfiles() {
        return userprofilerepo.findAll();
    }

	
	@PostMapping("/skills")
	public ResponseEntity<?> addSkill(@RequestBody UserSkill skill)
	{
		try {
			// Ignore ID if provided - let database generate it
			skill.setId(null);
			UserSkill savedSkill = skillrepo.save(skill);
			return ResponseEntity.ok(savedSkill);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("Error adding skill: " + e.getMessage() + " - " + e.getClass().getName());
		}
	}
	
	@PostMapping("/analyze/{userid}")
	public List<SkillGap> analyze(@PathVariable Long userid){
	

		return analysisService.analyzeCareer(userid);
	}
	
}
