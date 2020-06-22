package ucr.ac.cr.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ucr.ac.cr.api.entity.Province;
import ucr.ac.cr.api.service.jpa.ProvinceService;

import java.util.List;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/getProvinces")
    public List<Province> listProvinces (){

        return provinceService.listProvince();
    }
}
