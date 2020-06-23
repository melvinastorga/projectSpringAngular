package ucr.ac.cr.api.controller;

import java.util.List;
import java.util.NoSuchElementException;

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

import ucr.ac.cr.api.entity.Appointment;
import ucr.ac.cr.api.service.jpa.AppointmentService;
import ucr.ac.cr.api.service.jpa.CourseService;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api")
public class AppointmentController {

	@Autowired
	private AppointmentService service;
	
	
	@GetMapping("/getAppointmentByProfessorCourse/{professorCourseId}")
	public ResponseEntity<List<Appointment>> getAppointmentByProfessorCourse(@PathVariable Integer professorCourseId){
		try {
			List<Appointment> appointments = service.GetAppointmentByIdProfessorCourse(professorCourseId);
			return new ResponseEntity<List<Appointment>>(appointments, HttpStatus.OK);
		}catch(NoSuchElementException e){
			return new ResponseEntity<List<Appointment>>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/getAppointmentByProfessorCourseAccepted/{professorCourseId}")
	public ResponseEntity<List<Appointment>> getAppointmentByProfessorCourseAcepted(@PathVariable Integer professorCourseId){
		try {
			List<Appointment> appointments = service.getAppointmentByProfessorCourseAccepted(professorCourseId);
			return new ResponseEntity<List<Appointment>>(appointments, HttpStatus.OK);
		}catch(NoSuchElementException e){
			return new ResponseEntity<List<Appointment>>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@GetMapping("/getAppointmentByProfessorCourseHolded/{professorCourseId}")
	public ResponseEntity<List<Appointment>> getAppointmentByProfessorCourseHolded(@PathVariable Integer professorCourseId){
		try {
			List<Appointment> appointments = service.getAppointmentByProfessorCourseHolded(professorCourseId);
			return new ResponseEntity<List<Appointment>>(appointments, HttpStatus.OK);
		}catch(NoSuchElementException e){
			return new ResponseEntity<List<Appointment>>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@GetMapping("/getAppointmentByProfessorCourseRefused/{professorCourseId}")
	public ResponseEntity<List<Appointment>> getAppointmentByProfessorCourseRefused(@PathVariable Integer professorCourseId){
		try {
			List<Appointment> appointments = service.getAppointmentByProfessorCourseRefused(professorCourseId);
			return new ResponseEntity<List<Appointment>>(appointments, HttpStatus.OK);
		}catch(NoSuchElementException e){
			return new ResponseEntity<List<Appointment>>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@GetMapping("/getAppointmentById/{appointmentId}")
	public ResponseEntity<Appointment> getAppointmentById(@PathVariable Integer appointmentId){
		try {
			Appointment appointment = service.getAppointmentById(appointmentId);
			return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
		}catch(NoSuchElementException e){
			return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/saveAppointment")
	public ResponseEntity<?> insertAppointment(@RequestBody Appointment appointment) {
		service.insertAppointmentSP(appointment);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	
	@PostMapping("/updateAppointment")
	public ResponseEntity<?> updateAppointment(@RequestBody Appointment appointment) {
		service.updateAppointmentSP(appointment);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	

	@PostMapping("/acceptAppointment")
	public ResponseEntity<?> acceptAppointment(@RequestBody Appointment appointment) {
		service.acceptAppointmentSP(appointment);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@PostMapping("/refuseAppointment")
	public ResponseEntity<?> refuseAppointment(@RequestBody Appointment appointment) {
		service.refuseAppointmentSP(appointment);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteAppointment/{appointmentId}")
	public void deleteAppointment(@PathVariable("appointmentId") int appointmentId) {
		service.deleteAppointmentSP(appointmentId);
	}
}
