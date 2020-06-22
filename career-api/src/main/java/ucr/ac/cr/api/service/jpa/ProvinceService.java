package ucr.ac.cr.api.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.api.entity.Province;
import ucr.ac.cr.api.repository.ProvinceRepository;
import ucr.ac.cr.api.service.IProvince;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ProvinceService implements IProvince {

    @Autowired
    private ProvinceRepository provinceRepository;


    @Override
    public List<Province> listProvince() {
        return provinceRepository.getProvince();
    }
}
