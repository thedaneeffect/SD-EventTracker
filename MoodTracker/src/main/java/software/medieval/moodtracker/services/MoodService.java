package software.medieval.moodtracker.services;

import java.util.List;

import software.medieval.moodtracker.entities.Mood;

public interface MoodService {
	List<Mood> index();

	Mood save(Mood mood);
}
