package repository;

import newentity.WeeklyPlan;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WeeklyPlanRepository extends JpaRepository<WeeklyPlan, Long>{

	List<WeeklyPlan> findByUserId(Long userid);
	
}
