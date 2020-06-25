package ucr.ac.cr.api.controller;

import jdk.net.SocketFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucr.ac.cr.api.entity.Admin;
import ucr.ac.cr.api.entity.President;
import ucr.ac.cr.api.entity.Professor;
import ucr.ac.cr.api.service.jpa.AdminService;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/getAdmin")
    public ResponseEntity<Admin> getAdmin(){
        Admin admin = adminService.getAdmin();
        return new ResponseEntity(admin, HttpStatus.OK);
    }

    @PostMapping("/promoteProfessor/{professorId}/{updatedBy}")
    public ResponseEntity<?> promoteProfessor(@PathVariable Integer professorId, @PathVariable Integer updatedBy){
        Admin adminToReplace = adminService.getAdmin();
        //remove the old admin
        adminService.promoteProfessor(adminToReplace.personId, adminToReplace.personId);
        //replace the old admin
        adminService.promoteProfessor(professorId, updatedBy);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
