package examen.api.controller;

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

import examen.api.entity.Major;
import examen.api.service.jpa.MajorService;


@RestController
@CrossOrigin({"*"})
@RequestMapping("/api/major")
public class MajorController {

@Autowired
private MajorService service;
	

@GetMapping("/getAllMajors")
public List<Major> listActiveCourses(){
	return service.getAllMajors();
}


@GetMapping("/getMajor/{id}")
public ResponseEntity<Major> getMajorById(@PathVariable Integer id){
	try {
		Major course = service.GetMajorById(id);
		return new ResponseEntity<Major>(course, HttpStatus.OK);
	}catch(NoSuchElementException e){
		return new ResponseEntity<Major>(HttpStatus.NOT_FOUND);
	}
	
}


@DeleteMapping("/delete/{id}")
public void deleteMajor(@PathVariable("id") int id) {
	service.deleteMajor(id);
}


@PostMapping("/create")
public ResponseEntity<?> createMajor(@RequestBody Major major){
	try {
		service.insertMajor(major);
		return new ResponseEntity(HttpStatus.CREATED);
	}catch(Exception e){
		return new ResponseEntity(HttpStatus.CONFLICT);
	}
}

@PostMapping("/update")
	public ResponseEntity<?> updateMajor(@RequestBody Major major){
		try {
			service.updateMajor(major);
			return new ResponseEntity(HttpStatus.ACCEPTED);
		}catch(Exception e){
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
	}

}
