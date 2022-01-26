package software.medieval.moodtracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import software.medieval.moodtracker.entities.Mood;
import software.medieval.moodtracker.entities.MoodId;

public interface MoodRepository extends JpaRepository<Mood, MoodId> {
	List<Mood> findAllByUserId(int id);

}
