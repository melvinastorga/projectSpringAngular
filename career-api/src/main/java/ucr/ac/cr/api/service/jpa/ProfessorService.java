package ucr.ac.cr.api.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.api.entity.Professor;
import ucr.ac.cr.api.repository.ProfessorRepository;
import ucr.ac.cr.api.service.IProfesorService;

import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;

@Service
@Transactional
public class ProfessorService implements IProfesorService {

    @Autowired
    private ProfessorRepository professorRepository;

    long millis=System.currentTimeMillis();
    java.sql.Date date=new java.sql.Date(millis);

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
    public void insertProfessor(Professor professor) throws UnsupportedEncodingException {

        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);

        professor.setProfilePic(stringToByte(professor.getImgString()));

         professorRepository.insertProfessor(0,
                professor.getEmail(),
                professor.getPassword(),
                professor.getName(),
                professor.getLastName(),
                professor.getInterests(),
                professor.getProfilePic(),
                false,
                professor.getDistricId(),
                professor.getCantonId(),
                professor.getProvinceId(),
                 professor.personId,
                 date,
                 professor.personId,
                 date,
                "Professor",
                professor.getEspeciality(),
                "Insert");
    }

    @Override
    public void updateProfessor(Professor professor) throws UnsupportedEncodingException {

        professor.setProfilePic(stringToByte(professor.getImgString()));

        professorRepository.updateProfessor(professor.getPersonId(),
                professor.getEmail(),
                professor.getPassword(),
                professor.getName(),
                professor.getLastName(),
                professor.getInterests(),
                professor.getProfilePic(),
                true,
                professor.getDistricId(),
                professor.getCantonId(),
                professor.getProvinceId(),
                professor.personId,
                date,
                professor.personId,
                date,
                "Professor",
                professor.getEspeciality(),
                "Update");
    }

    public byte[] stringToByte(String string) throws UnsupportedEncodingException {
        byte[] name = Base64.getEncoder().encode(string.getBytes());
        byte[] decodedString = Base64.getDecoder().decode(new String(name).getBytes("UTF-8"));
        System.out.println(new String(decodedString));
        return name;
    }
}
