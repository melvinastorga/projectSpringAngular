package ucr.ac.cr.api.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ucr.ac.cr.api.entity.ProfessorCourse;
import ucr.ac.cr.api.service.jpa.CourseService;
import ucr.ac.cr.api.service.jpa.ProfessorCourseService;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api/professorCourse")
public class ProfessorCourseController {

	@Autowired
	private ProfessorCourseService service;
	

	
	@GetMapping("/getCourseByProfessor/{professorId}")
	public ResponseEntity<List<ProfessorCourse>> getCourseByProfessor(@PathVariable Integer professorId){
		try {
			List<ProfessorCourse> professorCourse = service.GetCourseByProfessor(professorId);
			return new ResponseEntity<List<ProfessorCourse>>(professorCourse, HttpStatus.OK);
		}catch(NoSuchElementException e){
			return new ResponseEntity<List<ProfessorCourse>>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@PostMapping("/insertUpdateProfessorCourse")
	public ResponseEntity<?> insertUpdateProfessorCourse(@RequestBody ProfessorCourse professorCourse) {
		service.insertUpdateProfessorCourseSP(professorCourse);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	
	@PostMapping("/deleteProfessorCourse")
	public ResponseEntity<?> deleteProfessorCourse(@RequestBody ProfessorCourse professorCourse) {
		service.deleteProfessorCourseSP(professorCourse);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
}
