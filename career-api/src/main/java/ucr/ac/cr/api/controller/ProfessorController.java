package ucr.ac.cr.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucr.ac.cr.api.entity.OfficeHours;
import ucr.ac.cr.api.entity.Professor;
import ucr.ac.cr.api.service.jpa.ProfessorService;

import java.util.List;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api")
public class ProfessorController {

    @Autowired
    private ProfessorService service;

    @GetMapping("/getProfessorById/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable Integer id){

        Professor professor = service.getProfessorById(id);
        return new ResponseEntity<Professor>(professor, HttpStatus.OK);
    }

   @GetMapping("/getAllProfessor")
    public List<Professor> getAllProfessor(){
        return service.getAllProfessor();
    }

    @GetMapping("/getProfessorsOff")
    public List<Professor> getProfessorsOff(){
        return service.getProfessorsOff();
    }

    @PostMapping("/postProfessor")
    public ResponseEntity<?> insertProfessor(@RequestBody Professor professor){
         service.insertProfessor(professor);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/updateProfessor")
    public void updateProfessor(@RequestBody Professor professor){
        service.updateProfessor(professor);
    }


}
