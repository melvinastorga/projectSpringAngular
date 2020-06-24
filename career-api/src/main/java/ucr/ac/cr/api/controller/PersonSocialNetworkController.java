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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucr.ac.cr.api.entity.Appointment;
import ucr.ac.cr.api.entity.PersonSocialNetwork;
import ucr.ac.cr.api.service.jpa.CourseService;
import ucr.ac.cr.api.service.jpa.PersonSocialNetworkService;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api/personSocialNetwork")
public class PersonSocialNetworkController {

	@Autowired
	private PersonSocialNetworkService service;

	
	@GetMapping("/getPersonSocialNetworkByPersonId/{personId}")
	public ResponseEntity<List<PersonSocialNetwork>> getAppointmentByProfessorCourseAcepted(@PathVariable Integer personId){
		try {
			List<PersonSocialNetwork> personSocialNetworks = service.getPersonSocialNetworkByPersonId(personId);
			return new ResponseEntity<List<PersonSocialNetwork>>(personSocialNetworks, HttpStatus.OK);
		}catch(NoSuchElementException e){
			return new ResponseEntity<List<PersonSocialNetwork>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/insertPersonSocialNetwork")
	public ResponseEntity<?> insertPersonSocialNetwork(@RequestBody PersonSocialNetwork personSocialNetwork) {
		service.insertPersonSocialNetworkSP(personSocialNetwork.getPersonSocialNetworkPK(), personSocialNetwork);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	
	@PostMapping("/updatePersonSocialNetwork")
	public ResponseEntity<?> updatePersonSocialNetwork(@RequestBody PersonSocialNetwork personSocialNetwork) {
		service.updatePersonSocialNetworkSP(personSocialNetwork.getPersonSocialNetworkPK(), personSocialNetwork);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deletePersonSocialNetwork/{socialNetworkId}/{personId}")
	public void deleteSP(@PathVariable("socialNetworkId") int socialNetworkId, @PathVariable("personId") int personId) {
		service.deletePersonSocialNetworkSP(socialNetworkId, personId);
	}
	
}
