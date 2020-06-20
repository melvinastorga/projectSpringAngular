package ucr.ac.cr.api.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucr.ac.cr.api.entity.ProfessorCourse;
import ucr.ac.cr.api.service.jpa.CourseService;
import ucr.ac.cr.api.service.jpa.ProfessorCourseService;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api")
public class ProfessorCourseController {

	@Autowired
	private ProfessorCourseService service;
	

	
	@GetMapping("/getCourseByProfessor/{id}")
	public ResponseEntity<ProfessorCourse> getCourseByProfessor(@PathVariable Integer id){
		try {
			ProfessorCourse professorCourse = service.GetCourseByProfessor(id);
			return new ResponseEntity<ProfessorCourse>(professorCourse, HttpStatus.OK);
		}catch(NoSuchElementException e){
			return new ResponseEntity<ProfessorCourse>(HttpStatus.NOT_FOUND);
		}
		
	}
	
}
