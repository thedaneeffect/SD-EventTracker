package software.medieval.moodtracker.services;

import software.medieval.moodtracker.entities.User;

public interface UserService {
	boolean existsByName(String name);

	User getByName(String name);
	
	int getIdByName(String name);

	User save(User user);
}
