package software.medieval.moodtracker.controllers;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import software.medieval.moodtracker.entities.Mood;
import software.medieval.moodtracker.entities.MoodId;
import software.medieval.moodtracker.entities.User;
import software.medieval.moodtracker.services.MoodService;
import software.medieval.moodtracker.services.UserService;

@Data
class MoodStub {
	private String date;
	private int value;
	private String description;
}

@RestController
@CrossOrigin({ "*", "http://localhost:4200" })
@RequestMapping("api/users")
public class UserController {

	@Autowired
	private MoodService moods;
	
	@Autowired
	private UserService users;
	
	@GetMapping("{userId}/moods")
	public List<Mood> getMoods(@PathVariable int userId) {
		return moods.getAllByUserId(userId);
	}
	
	@PutMapping("{userId}/moods")
	public void saveMood(Principal principal, @PathVariable int userId, @RequestBody MoodStub stub, HttpServletResponse res) throws IOException {
		User user = users.getByName(principal.getName());
		if (user == null) {
			res.sendError(HttpStatus.BAD_REQUEST.value());
			return;
		} else if (user.getId() != userId) {
			res.sendError(HttpStatus.UNAUTHORIZED.value());
			return;
		}
		
		Mood mood = new Mood();
		mood.setId(stub.getDate());
		mood.setUserId(userId);
		mood.setValue(stub.getValue());
		mood.setDescription(stub.getDescription());
		moods.save(mood);
		res.setStatus(HttpStatus.ACCEPTED.value());
	}

}
