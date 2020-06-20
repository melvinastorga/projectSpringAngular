package ucr.ac.cr.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucr.ac.cr.api.entity.Course;
import ucr.ac.cr.api.service.jpa.CourseService;

@RestController
@RequestMapping("/api")
public class CourseController {
	
	@Autowired
	private CourseService service;

	@GetMapping("/courses")
	public List<Course> list(){
		return service.ListAll();
	}
}
