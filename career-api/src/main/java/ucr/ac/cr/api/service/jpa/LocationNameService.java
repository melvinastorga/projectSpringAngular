package ucr.ac.cr.api.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.api.entity.LocationNames;
import ucr.ac.cr.api.repository.LocationNamesRepository;
import ucr.ac.cr.api.service.ILocationNames;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LocationNameService implements ILocationNames {

    @Autowired
    LocationNamesRepository locationNamesRepository;

    @Override
    public LocationNames getLocationNames(int provinceId, int cantonId, int districtId) {
        return locationNamesRepository.getLocationNames(provinceId, cantonId, districtId);
    }
}
