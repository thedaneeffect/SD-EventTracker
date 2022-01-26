package software.medieval.moodtracker.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import software.medieval.moodtracker.entities.User;
import software.medieval.moodtracker.services.AuthService;

@RestController
@CrossOrigin({ "*", "http://localhost:4200" })
public class AuthController {

	@Autowired
	private AuthService service;

	@PostMapping("/register")
	public void register(@RequestBody User user, HttpServletResponse res) throws Exception {
		try {
			service.register(user);
			res.setStatus(HttpStatus.ACCEPTED.value());
		} catch (AuthService.Error error) {
			res.sendError(HttpStatus.BAD_REQUEST.value(), error.getMessage());
		}
	}

	@GetMapping("/login")
	public int login(Principal principal) {
		return service.getUserByName(principal.getName()).getId();
	}

}
