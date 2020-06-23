package ucr.ac.cr.api.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.api.repository.PersonRepository;
import ucr.ac.cr.api.service.IPerson;

import javax.transaction.Transactional;

@Service
@Transactional
public class PersonService implements IPerson {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void desactivatePerson(int personId, int updatedBy) {
        personRepository.desactivatePerson(personId, updatedBy);
    }

    @Override
    public void activatePerson(int personId, int updatedBy) {
        personRepository.activatePerson(personId, updatedBy);
    }
}
