package ucr.ac.cr.api.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.api.entity.President;
import ucr.ac.cr.api.repository.PresidentRepository;
import ucr.ac.cr.api.service.IPresident;

import javax.transaction.Transactional;

@Service
@Transactional
public class PresidentService implements IPresident {

    @Autowired
    PresidentRepository presidentRepository;

    @Override
    public void promoteStudent(int studentId, int updatedBy) {
        presidentRepository.promoteStudent(studentId, updatedBy);
    }

    @Override
    public President getPresident() {
        return presidentRepository.getPresident();
    }




}
