package examen.api.controller;

import java.awt.print.Printable;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.JOptionPane;

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
	

@GetMapping("/getMajors")
public List<Major> get_courses(){
	
	try {
	return service.get_majors();
	}catch(NoSuchElementException e){
		return (List<Major>) new ResponseEntity (HttpStatus.NOT_FOUND);
	}

}


@GetMapping("/getMajor/{id}")
public ResponseEntity<Major> get_major(@PathVariable Integer id){
	try {
		Major course = service.get_major(id);
		return new ResponseEntity<Major>(course, HttpStatus.OK);
	}catch(NoSuchElementException e){
		return new ResponseEntity<Major>(HttpStatus.NOT_FOUND);
	}
	
}


@DeleteMapping("/delete/{id}")
public void deleteMajor(@PathVariable("id") int id) {
	
	try {

      service.delete_major(id);
      
	}catch(NoSuchElementException e){
		
		System.out.print(e);;
	}
}



@PostMapping("/postMajor")
public ResponseEntity<?> insert_major(@RequestBody Major major){
	try {
		service.insert_major(major);
		return new ResponseEntity(HttpStatus.CREATED);
	}catch(Exception e){
		return new ResponseEntity(HttpStatus.CONFLICT);
	}
}

@PostMapping("/putMajor")
	public ResponseEntity<?> update_major(@RequestBody Major major){
		try {
			service.update_major(major);
			return new ResponseEntity(HttpStatus.ACCEPTED);
		}catch(Exception e){
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
	}

}
