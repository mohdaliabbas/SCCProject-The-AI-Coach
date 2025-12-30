package service;

import org.springframework.stereotype.Service;

@Service
public class SkillGapService {
	
	public String explainGap(String skill) {
		return skill + "critical for backend interviews and system reliability";
	}
}
