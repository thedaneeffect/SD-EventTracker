package software.medieval.moodtracker.services;

import java.time.Instant;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.medieval.moodtracker.entities.Occurance;
import software.medieval.moodtracker.repositories.OccuranceRepository;

@Transactional
@Service
public class OccuranceServiceImpl implements OccuranceService {

	@Autowired
	private OccuranceRepository repo;

	@Override
	public List<Occurance> index() {
		return repo.findAll();
	}

	@Override
	public List<Occurance> findAllBetween(Instant from, Instant to) {
		return repo.findByHappenedAtBetween(from, to);
	}

	@Override
	public Occurance create(Occurance occurance) {
		return repo.save(occurance);
	}

	@Override
	public Occurance findById(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public boolean deleteById(int id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}
	
}
