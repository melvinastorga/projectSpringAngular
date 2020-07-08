package ucr.ac.cr.api.controller;

import java.util.NoSuchElementException;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;
import ucr.ac.cr.api.entity.*;
import ucr.ac.cr.api.service.jpa.LocationNameService;
import ucr.ac.cr.api.service.jpa.LoginTestService;
import ucr.ac.cr.api.service.jpa.ProfessorService;
import ucr.ac.cr.api.service.jpa.StudentService;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api")
public class LoginController {

	@Autowired
	private LoginTestService service;

	@Autowired
	private StudentService studentService;

	@Autowired
	private ProfessorService professorService;

	@Autowired
	private LocationNameService locationNameService;

	@PostMapping("/authenticateUser")
	public ResponseEntity<UserModel> getLoginTest(@RequestBody LoginModel loginModel){
		UserModel user = new UserModel();
		try {
			Login login = service.GetLogin(loginModel.getEmail(), loginModel.getPassword());

			if(login.getRole().equals("Student") && login.isStatus()){

				Student student = studentService.getStudentById(login.getPersonId());
				LocationNames locationNames = locationNameService.getLocationNames(student.getProvinceId(), student.getCantonId(), student.getDistricId());
				user.setStudent(student);
				user.setLocationNames(locationNames);

			}else if(login.getRole().equals("professor") && login.isStatus()){

				Professor professor = professorService.getProfessorById(login.getPersonId());
				LocationNames locationNames = locationNameService.getLocationNames(professor.getProvinceId(), professor.getCantonId(), professor.getDistricId());

				user.setProfessor(professor);
				user.setLocationNames(locationNames);

			}
			return new ResponseEntity<UserModel>(user, HttpStatus.OK);

		}catch(NoSuchElementException e){
			return new ResponseEntity<UserModel>(HttpStatus.NOT_FOUND);
		}
	}
	
}
