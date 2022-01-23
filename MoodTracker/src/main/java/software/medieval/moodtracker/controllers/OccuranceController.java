package software.medieval.moodtracker.controllers;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import software.medieval.moodtracker.entities.Occurance;
import software.medieval.moodtracker.services.OccuranceService;

@Data
class DateRange {
	private LocalDateTime from;
	private LocalDateTime to;
}

@RestController
@RequestMapping("api/occurances")
public class OccuranceController {

	@Autowired
	private OccuranceService service;
	
	@GetMapping
	public List<Occurance> index() {
		return service.index();
	}

	@GetMapping("{id}")
	public Occurance index(@PathVariable int id) {
		return service.findById(id);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable int id, HttpServletResponse res) throws Exception {
		if (!service.deleteById(id)) {
			res.sendError(HttpStatus.NOT_FOUND.value());
		}
	}
	
	@GetMapping("find")
	public List<Occurance> find(@RequestBody DateRange range) {
		return service.findAllBetween(range.getFrom(), range.getTo());
	}
}
