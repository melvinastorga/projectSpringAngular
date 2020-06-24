package ucr.ac.cr.api.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucr.ac.cr.api.entity.CourseProfessor;
import ucr.ac.cr.api.service.jpa.CourseProfessorService;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api/courseProfessor")
public class CourseProfessorController {

	
	@Autowired
	private CourseProfessorService service;
	
	//List all the professors of a course
	@GetMapping("/getProfessorByCourse/{courseId}")
	public ResponseEntity<List<CourseProfessor>> getCourseByProfessor(@PathVariable Integer courseId){
		try {
			List<CourseProfessor> courseProfessor = service.getProfessorByCourse(courseId);
			return new ResponseEntity<List<CourseProfessor>>(courseProfessor, HttpStatus.OK);
		}catch(NoSuchElementException e){
			return new ResponseEntity<List<CourseProfessor>>(HttpStatus.NOT_FOUND);
		}
		
	}
	
}
