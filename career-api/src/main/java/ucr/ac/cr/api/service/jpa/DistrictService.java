package ucr.ac.cr.api.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.api.entity.Distric;
import ucr.ac.cr.api.repository.DistricRepository;
import ucr.ac.cr.api.service.IDistric;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class DistrictService implements IDistric {

    @Autowired
    private DistricRepository districRepository;

    @Override
    public List<Distric> listDistricByCantonProvince(int provinceId, int cantonId) {
        return districRepository.getDistrictByProvinceCanton(provinceId, cantonId);
    }
}
