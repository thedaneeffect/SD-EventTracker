package software.medieval.moodtracker.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import software.medieval.moodtracker.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByName(String name);
	Optional<Integer> findIdByName(String name);
	boolean existsByName(String name);
}
