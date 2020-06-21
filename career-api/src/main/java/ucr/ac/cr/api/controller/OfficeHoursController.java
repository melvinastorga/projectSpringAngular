package ucr.ac.cr.api.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucr.ac.cr.api.entity.OfficeHours;
import ucr.ac.cr.api.service.jpa.OfficeHoursService;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api")
public class OfficeHoursController {

	@Autowired
	private OfficeHoursService service;
	
	
	@GetMapping("/getAllOfficeHours")
	public List<OfficeHours> getAllOfficeHours() {
		return service.ListAllOfficeHours();
	}
	
	@GetMapping("/getOfficeHoursById/{id}")
	public ResponseEntity<OfficeHours> getStudentById(@PathVariable Integer id){
		try {
			OfficeHours officeHours = service.GetOfficeHoursById(id);
			return new ResponseEntity<OfficeHours>(officeHours, HttpStatus.OK);
		}catch(NoSuchElementException e){
			return new ResponseEntity<OfficeHours>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getAllOfficeHoursByCourse/{professorCourseId}")
	public List<OfficeHours> getOfficeHoursByCourse(@PathVariable Integer professorCourseId) {
		return service.GetOfficeHoursByCourse(professorCourseId);
	}
	
	@PostMapping("/saveOfficeHours")
	public ResponseEntity<?> insertOfficeHours(@RequestBody OfficeHours officeHours) {
		service.insertOfficeHours(officeHours);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@PostMapping("/updateOfficeHours")
	public void updateStudent(@RequestBody OfficeHours officeHours){
	
		service.updateOfficeHours(officeHours);
	}
	
	@DeleteMapping("/deleteOfficeHours/{id}")
	public void deleteOfficeHoursSP(@PathVariable("id") int id) {
		service.deleteOfficeHours(id);
	}
	
}
