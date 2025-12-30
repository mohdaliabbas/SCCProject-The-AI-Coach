package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.ProgressService;
import newentity.DailyProgress;

@RestController
@RequestMapping("/api")
public class DailyController {
	@Autowired
	private ProgressService progressservice;
	@PostMapping("/progress")
	public DailyProgress updateProgress(@RequestBody DailyProgress progress) {
		return progressservice.markProgress(progress);
	}
	
	@GetMapping("/progress/{userId}")
	public double getCompletion(@PathVariable Long userId) {
		return progressservice.calcCompletion(userId);
	}
}
