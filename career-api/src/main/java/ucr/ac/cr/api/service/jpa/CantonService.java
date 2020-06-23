package ucr.ac.cr.api.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.api.entity.Canton;
import ucr.ac.cr.api.repository.CantonRepository;
import ucr.ac.cr.api.service.ICanton;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CantonService implements ICanton {

    @Autowired
    private CantonRepository cantonRepository;

    @Override
    public List<Canton> listCantonByProvince(int provinceId) {
        return cantonRepository.getCantonByProvince(provinceId);
    }
}
