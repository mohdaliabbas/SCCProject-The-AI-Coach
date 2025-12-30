package repository;

import newentity.DailyProgress;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyProgressRepository extends JpaRepository<DailyProgress, Long> {
     	List<DailyProgress> findByUserId(Long userId);
     	
}
