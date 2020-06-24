package ucr.ac.cr.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucr.ac.cr.api.entity.Course;
import ucr.ac.cr.api.entity.SocialNetwork;
import ucr.ac.cr.api.service.jpa.CourseService;
import ucr.ac.cr.api.service.jpa.SocialNetworkService;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api/socialNetwork")
public class SocialNetworkController {

	@Autowired
	private SocialNetworkService service;

	
	@GetMapping("/GetSocialNetworks")
	public List<SocialNetwork> getSocialNetwork(){
		return service.getAllSocialNetworks();
	}
	
}
