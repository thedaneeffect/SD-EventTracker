package software.medieval.moodtracker.services;

import java.time.LocalDate;
import java.util.List;

import software.medieval.moodtracker.entities.Mood;

public interface MoodService {
	List<Mood> index();
	
	Mood index(LocalDate id);

	Mood save(Mood mood);
}
