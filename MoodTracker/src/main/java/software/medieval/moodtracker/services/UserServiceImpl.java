package software.medieval.moodtracker.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.medieval.moodtracker.entities.User;
import software.medieval.moodtracker.repositories.UserRepository;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;

	@Override
	public boolean existsByName(String name) {
		return repo.existsByName(name);
	}

	@Override
	public User getByName(String name) {
		return repo.findByName(name)
			.orElse(null);
	}
	
	@Override
	public int getIdByName(String name) {
		return repo.findIdByName(name).orElse(-1);
	}

	@Override
	public User save(User user) {
		return repo.saveAndFlush(user);
	}

}
