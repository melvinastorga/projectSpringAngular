package ucr.ac.cr.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucr.ac.cr.api.entity.Professor;
import ucr.ac.cr.api.entity.Student;
import ucr.ac.cr.api.entity.StudentDTO;
import ucr.ac.cr.api.service.jpa.ProfessorService;
import ucr.ac.cr.api.service.jpa.StudentService;

import java.util.List;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("/getStudentById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id){

        Student student = service.getStudentById(id);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @GetMapping("/getAllStudent")
    public List<Student> getAllStudent(){
        return service.listAllStudent();
    }

    @GetMapping("/getStudentToAttend")
    public List<Student> getStudentsToAttend(){
        return service.getStudentstoAttend();
    }

    @PostMapping("/postStudent")
    public ResponseEntity<?> insertStudent(@RequestBody Student student){
        service.insertStudent(student);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/serveStudentAccount/{studentId}/{updatedBy/{action}")
    public ResponseEntity<?> serveAccount(@PathVariable Integer studentId, Integer updatedBy, String action){
        service.serveStudentAccount(studentId, updatedBy, action);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/updateStudent")
    public ResponseEntity<?> updateStudent(@RequestBody Student student){
        service.updateStudent(student);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
