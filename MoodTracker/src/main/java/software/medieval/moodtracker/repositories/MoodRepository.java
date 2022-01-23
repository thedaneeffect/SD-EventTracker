package software.medieval.moodtracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import software.medieval.moodtracker.entities.Mood;

public interface MoodRepository extends JpaRepository<Mood, Integer> {

}
