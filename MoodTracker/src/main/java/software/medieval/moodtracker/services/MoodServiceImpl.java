package software.medieval.moodtracker.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.medieval.moodtracker.entities.Mood;
import software.medieval.moodtracker.repositories.MoodRepository;

@Transactional
@Service
public class MoodServiceImpl implements MoodService {

	@Autowired
	private MoodRepository repo;
	
	@Override
	public List<Mood> getAllByUserId(int userId) {
		return repo.findAllByUserId(userId);
	}

	@Override
	public Mood save(Mood mood) {
		return repo.saveAndFlush(mood);
	}

}
