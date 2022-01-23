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
	public List<Mood> index() {
		return repo.findAll();
	}

	@Override
	public Mood create(Mood mood) {
		return repo.save(mood);
	}

	@Override
	public Mood findById(int id) {
		return repo.findById(id).orElse(null);
	}

}
