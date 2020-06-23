package ucr.ac.cr.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucr.ac.cr.api.entity.Canton;
import ucr.ac.cr.api.service.jpa.CantonService;

import java.util.List;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api")
public class CantonController {

    @Autowired
    private CantonService cantonService;

    @GetMapping("/getCanton/{provinceId}")
    public List<Canton> getCantonByProvince(@PathVariable Integer provinceId){
        return cantonService.listCantonByProvince(provinceId);
    }
}
