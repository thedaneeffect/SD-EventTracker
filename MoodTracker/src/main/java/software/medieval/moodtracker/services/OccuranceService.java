package software.medieval.moodtracker.services;

import java.time.Instant;
import java.util.List;

import software.medieval.moodtracker.entities.Occurance;

public interface OccuranceService {
	List<Occurance> index();

	List<Occurance> findAllBetween(Instant from, Instant to);

	Occurance create(Occurance occurance);

	Occurance findById(int id);
	
	boolean deleteById(int id);
}
