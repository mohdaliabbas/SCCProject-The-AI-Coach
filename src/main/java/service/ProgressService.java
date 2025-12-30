package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import newentity.DailyProgress;
import repository.DailyProgressRepository;
import repository.UserProfileRepository;

import java.util.List;

//import jakarta.persistence.Service;

@Service
public class ProgressService {
		@Autowired
		private DailyProgressRepository Dailyrepo;
		@Autowired
		private UserProfileRepository profilerepo;
		
		public DailyProgress markProgress(DailyProgress progress) {
			Long userId = progress.getUserId();
			
			// Reject if the user does not exist
			if (userId == null || !profilerepo.existsById(userId)) {
				throw new IllegalArgumentException("User not found for id " + userId);
			}
			
			// If an id is provided, update the existing record; otherwise create new
			if (progress.getId() != null) {
				DailyProgress existing = Dailyrepo.findById(progress.getId())
						.orElseThrow(() -> new IllegalArgumentException("Progress not found for id " + progress.getId()));
				existing.setDay(progress.getDay());
				existing.setUserId(progress.getUserId());
				existing.setCompleted(progress.isCompleted());
				existing.setFeedback(progress.getFeedback());
				return Dailyrepo.save(existing);
			}

			// Force insert even if a client sends an id=null
			progress.setId(null);
			return Dailyrepo.save(progress);
		}
		
		public double calcCompletion(Long userId) {
			List<DailyProgress> progressList=Dailyrepo.findByUserId(userId);
			long completed=progressList.stream().filter(DailyProgress::isCompleted).count();
			return progressList.isEmpty()?0:(completed*100)/progressList.size();
		}
		
}
