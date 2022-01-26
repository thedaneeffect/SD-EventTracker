package software.medieval.moodtracker.services;

import java.util.List;

import software.medieval.moodtracker.entities.Mood;

public interface MoodService {
	List<Mood> getAllByUserId(int userId);

	Mood save(Mood mood);
}
