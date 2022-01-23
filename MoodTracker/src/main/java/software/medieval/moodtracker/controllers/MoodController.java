package software.medieval.moodtracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import software.medieval.moodtracker.entities.Mood;
import software.medieval.moodtracker.services.MoodService;

@RestController
@RequestMapping("api/moods")
public class MoodController {

	@Autowired
	private MoodService service;
	
	@GetMapping
	public List<Mood> index() {
		return service.index();
	}
	
	@GetMapping("{id}")
	public Mood index(@PathVariable int id) {
		return service.findById(id);
	}
	
}