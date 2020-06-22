package ucr.ac.cr.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucr.ac.cr.api.entity.LocationNames;
import ucr.ac.cr.api.service.jpa.LocationNameService;

import java.util.List;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api")
public class LocationNamesController {

    @Autowired
    LocationNameService locationNameService;

    @GetMapping("/getLocationNames/{provinceId}/{cantonId}/{districtId}")
    public LocationNames getLocationsNames(@PathVariable Integer provinceId, @PathVariable Integer cantonId, @PathVariable Integer districtId){
        return locationNameService.getLocationNames(provinceId, cantonId, districtId);
    }
}
