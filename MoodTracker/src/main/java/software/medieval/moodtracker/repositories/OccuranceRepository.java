package software.medieval.moodtracker.repositories;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import software.medieval.moodtracker.entities.Occurance;

public interface OccuranceRepository extends JpaRepository<Occurance, Integer> {

	List<Occurance> findByHappenedAtBetween(Instant from, Instant to);
	
}
