package software.medieval.moodtracker.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import software.medieval.moodtracker.entities.Occurance;

public interface OccuranceRepository extends JpaRepository<Occurance, Integer> {

	List<Occurance> findByHappenedAtBetween(LocalDateTime from, LocalDateTime to);
	
}
