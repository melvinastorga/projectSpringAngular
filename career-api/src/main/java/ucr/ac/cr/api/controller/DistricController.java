package ucr.ac.cr.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucr.ac.cr.api.entity.Distric;
import ucr.ac.cr.api.service.jpa.DistrictService;

import java.util.List;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api")
public class DistricController {

    @Autowired
    public DistrictService districtService;

    @GetMapping("/getDistric/{provinceId}/{cantonId}")
    public List<Distric> getDistric(@PathVariable Integer provinceId, @PathVariable Integer cantonId){
        return districtService.listDistricByCantonProvince(provinceId, cantonId);
    }
}
