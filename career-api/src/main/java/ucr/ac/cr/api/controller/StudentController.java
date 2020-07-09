package ucr.ac.cr.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucr.ac.cr.api.entity.*;
import ucr.ac.cr.api.service.jpa.LocationNameService;
import ucr.ac.cr.api.service.jpa.ProfessorService;
import ucr.ac.cr.api.service.jpa.StudentService;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService service;

    @Autowired
    private LocationNameService locationNameService;

    @GetMapping("/getStudentById/{id}")
    public ResponseEntity<UserModel> getStudentById(@PathVariable Integer id) throws UnsupportedEncodingException {
        UserModel user = new UserModel();
        Student student = service.getStudentById(id);

        LocationNames locationNames = locationNameService.getLocationNames(student.getProvinceId(), student.getCantonId(), student.getDistricId());
        user.setStudent(student);
        user.setLocationNames(locationNames);

        return new ResponseEntity<UserModel>(user, HttpStatus.OK);
    }

    @GetMapping("/getAllStudent")
    public List<Student> getAllStudent(){
        return service.listAllStudent();
    }

    @GetMapping("/getStudentToAttend")
    public List<Student> getStudentsToAttend(){
        return service.getStudentstoAttend();
    }

    @GetMapping("/getStudentsOff")
    public List<Student> getStudentsOff(){
        return service.getStudentsOff();
    }

    @PostMapping("/postStudent")
    public ResponseEntity<?> insertStudent(@RequestBody Student student) throws UnsupportedEncodingException {
        service.insertStudent(student);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/acceptStudentAccount/{studentId}/{updatedBy}")
    public ResponseEntity<?> acceptAccount(@PathVariable Integer studentId, @PathVariable Integer updatedBy){
        service.serveStudentAccount(studentId, updatedBy, "Accept");
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/rejectStudentAccount/{studentId}/{updatedBy}")
    public ResponseEntity<?> rejectAccount(@PathVariable Integer studentId, @PathVariable Integer updatedBy){
        service.serveStudentAccount(studentId, updatedBy, "Reject");
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/updateStudent")
    public ResponseEntity<?> updateStudent(@RequestBody Student student){
        service.updateStudent(student);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
