package ucr.ac.cr.api.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.api.entity.Professor;
import ucr.ac.cr.api.repository.ProfessorRepository;
import ucr.ac.cr.api.service.IProfesorService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProfessorService implements IProfesorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public Professor getProfessorById(int id){

        return professorRepository.getProfessorById(id);
    }

    @Override
    public List<Professor> getAllProfessor(){

        return professorRepository.getAllProfessor();
    }

    @Override
    public List<Professor> getProfessorsOff(){

        return professorRepository.getProfessorsOff();
    }

    @Override
    public void insertProfessor(Professor professor){

         professorRepository.insertProfessor(0,
                professor.getEmail(),
                professor.getPassword(),
                professor.getName(),
                professor.getLastName(),
                professor.getInterests(),
                professor.getProfilePic(),
                professor.isStatus(),
                professor.getDistricId(),
                professor.getCantonId(),
                professor.getProvinceId(),
                professor.getCreatedBy(),
                professor.getCreateAt(),
                professor.getUpdatedBy(),
                professor.getUpdatedAt(),
                "Professor",
                professor.getEspeciality(),
                "Insert");
    }

    @Override
    public void updateProfessor(Professor professor){

        professorRepository.updateProfessor(professor.getPersonId(),
                professor.getEmail(),
                professor.getPassword(),
                professor.getName(),
                professor.getLastName(),
                professor.getInterests(),
                professor.getProfilePic(),
                professor.isStatus(),
                professor.getDistricId(),
                professor.getCantonId(),
                professor.getProvinceId(),
                professor.getCreatedBy(),
                professor.getCreateAt(),
                professor.getUpdatedBy(),
                professor.getUpdatedAt(),
                "Professor",
                professor.getEspeciality(),
                "Update");
    }

}
