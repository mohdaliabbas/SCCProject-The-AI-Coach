package service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import repository.SkillGapRepository;
import repository.UserProfileRepository;
import repository.UserSkillRepository;
import entity.SkillGap;
import entity.UserProfile;
//import entity.UserProfile;
import entity.UserSkill;
import java.util.*;

@Service
public class CareerAnalysisService {

		@Autowired
		private UserProfileRepository profilerepo;
		@Autowired
		private UserSkillRepository skillRepo;
		@Autowired
		private SkillGapRepository gaprepo;
		@Autowired
		private CareerRuleEngine rulengine;
		
		public List<SkillGap> analyzeCareer(Long userid){
			UserProfile profile = profilerepo.findById(userid)
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found: " + userid));
			
			List<UserSkill> skills = skillRepo.findByUserId(userid);
			List<SkillGap> gaps = rulengine.analyze(profile,skills);
			return gaprepo.saveAll(gaps);
		}
		
}
