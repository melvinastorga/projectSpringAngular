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

import ucr.ac.cr.api.entity.Course;
import ucr.ac.cr.api.service.jpa.CourseService;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api/course")
public class CourseController {
	
	@Autowired
	private CourseService service;

	@GetMapping("/getActivecourses")
	public List<Course> listActiveCourses(){
		return service.ListActiveCourses();
	}
	
	@GetMapping("/getOffcourses")
	public List<Course> listOffCourses(){
		return service.ListOffCourses();
	}
	
	@GetMapping("/getCourse/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable Integer id){
		try {
			Course course = service.GetCourseById(id);
			return new ResponseEntity<Course>(course, HttpStatus.OK);
		}catch(NoSuchElementException e){
			return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/insertCourse")
	public ResponseEntity<?> insertCourse(@RequestBody Course course) {
		service.insertCourseSP(course);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@PostMapping("/updateCourse")
	public void updateCourse(@RequestBody Course course){
	
		service.updateCourseSP(course);
	
	}
	
	@PostMapping("/deleteCourse")
	public void deleteCourse(@RequestBody Course course){
	
		service.deleteCourseSP(course);
	
	}
	
	@PostMapping("/activeCourse")
	public void activeCourse(@RequestBody Course course){
	
		service.activeCourseSP(course);
	
	}
	
}
