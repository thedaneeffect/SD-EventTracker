package software.medieval.moodtracker.services;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import software.medieval.moodtracker.entities.User;

@Transactional
@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserService users;

	@Autowired
	private PasswordEncoder encoder;

	public User getUserByName(String name) {
		return users.getByName(name);
	}

	@Override
	public int getUserIdByName(String name) {
		return users.getIdByName(name);
	}
	
	@Override
	public User register(User user) throws Error, Exception {
		if (users.existsByName(user.getName())) {
			throw ERROR_NAME_TAKEN;
		}
		user.setPassword(encoder.encode(user.getPassword()));
		user.setEnabled(true);
		user.setRole("standard");
		user.setUuid(UUID.randomUUID().toString());
		
		return users.save(user);
	}

}
