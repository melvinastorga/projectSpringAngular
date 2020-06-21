package ucr.ac.cr.api.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucr.ac.cr.api.entity.LoginTest;
import ucr.ac.cr.api.entity.OfficeHours;
import ucr.ac.cr.api.service.jpa.LoginTestService;
import ucr.ac.cr.api.service.jpa.OfficeHoursService;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api")
public class LoginTestController {

	@Autowired
	private LoginTestService service;
	
	@GetMapping("/getLoginTest/{email}/{password}")
	public ResponseEntity<LoginTest> getLoginTest(@PathVariable String email, @PathVariable String password){
		try {
			LoginTest loginTet = service.GetLogin(email, password);
			return new ResponseEntity<LoginTest>(loginTet, HttpStatus.OK);
		}catch(NoSuchElementException e){
			return new ResponseEntity<LoginTest>(HttpStatus.NOT_FOUND);
		}
	}
	
}
