package examen.api.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import examen.api.entity.Major;
import examen.api.service.jpa.MajorService;


@RestController
@CrossOrigin({"*"})
@RequestMapping("/api/")
public class MajorController {

@Autowired
private MajorService service;

@GetMapping("/getMajors")
public List<Major> getMajors(){
	return service.getMajors();
}

@GetMapping("/getMajor/{id}")
    public ResponseEntity<Major> getMajorById(@PathVariable Integer id){
        try {
            Major course = service.getMajorById(id);
            return new ResponseEntity<Major>(course, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Major>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/deleteMajor/{id}")
    public void deleteMajor(@PathVariable("id") int id) {
        service.deleteMajor(id);
    }


@PostMapping("/postMajor")
public ResponseEntity<?> insertMajor(@RequestBody Major major){
	try {
		service.insertMajor(major);
		return new ResponseEntity(HttpStatus.CREATED);
	}catch(Exception e){
		return new ResponseEntity(HttpStatus.CONFLICT);
	}
}

@PostMapping("/putMajor")
	public ResponseEntity<?> updateMajor(@RequestBody Major major){
		try {
			service.updateMajor(major);
			return new ResponseEntity(HttpStatus.ACCEPTED);
		}catch(Exception e){
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
	}

}
