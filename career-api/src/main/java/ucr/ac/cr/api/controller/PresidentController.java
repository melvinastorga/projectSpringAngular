package ucr.ac.cr.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucr.ac.cr.api.entity.President;
import ucr.ac.cr.api.service.jpa.PresidentService;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api/president")
public class PresidentController {

    @Autowired
    PresidentService presidentService;

    @GetMapping("/getPresident")
    public ResponseEntity<President> getPresident(){
        President president = presidentService.getPresident();
        return new ResponseEntity(president, HttpStatus.OK);
    }

    @PostMapping("/promoteStudent/{studentId}/{updatedBy}")
    public ResponseEntity<?> promoteStudent(@PathVariable Integer studentId, @PathVariable Integer updatedBy){
        President presidentToReplace = presidentService.getPresident();
        //remove the old president
        presidentService.promoteStudent(presidentToReplace.personId, presidentToReplace.personId);
        //replace with the new president
        presidentService.promoteStudent(studentId, updatedBy);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
