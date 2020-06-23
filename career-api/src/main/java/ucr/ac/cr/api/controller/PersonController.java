package ucr.ac.cr.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucr.ac.cr.api.service.jpa.PersonService;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonService personService;

    @DeleteMapping("/desactivateAccount/{personId}/{updatedBy}")
    public ResponseEntity<?> deleteAccount(@PathVariable  Integer personId, @PathVariable Integer updatedBy){
        personService.desactivatePerson(personId, updatedBy);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/activateAccount/{personId}/{updatedBy}")
    public ResponseEntity<?> activateAccount(@PathVariable  Integer personId, @PathVariable Integer updatedBy){
        personService.activatePerson(personId, updatedBy);
        return new ResponseEntity(HttpStatus.OK);
    }
}
