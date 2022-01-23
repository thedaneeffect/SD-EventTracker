package software.medieval.moodtracker.services;

import java.util.List;

import software.medieval.moodtracker.entities.Mood;

public interface MoodService {
	List<Mood> index();

	Mood create(Mood mood);

	Mood findById(int id);
}
