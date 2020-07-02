package ucr.ac.cr.api.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.api.entity.Student;
import ucr.ac.cr.api.repository.StudentRepository;
import ucr.ac.cr.api.service.IStudentService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentService implements IStudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SendMailService emailService;

    @Override
    public List<Student> listAllStudent(){
        return studentRepository.getAllStudent();
    }

    @Override
    public Student getStudentById(int id){
        return studentRepository.getStudentById(id);
    }

    @Override
    public void insertStudent(Student student){
        studentRepository.insertStudent(0,
                student.getEmail(),
                student.getPassword(),
                student.getName(),
                student.getLastName(),
                student.getInterests(),
                student.getProfilePic(),
                false,
                student.getDistricId(),
                student.getCantonId(),
                student.getProvinceId(),
                student.getCreateAt(),
                student.getUpdatedBy(),
                student.getUpdatedAt(),
                student.getRole(),
                student.getCarne(),
                "Insert");
    }

    @Override
    public void updateStudent(Student student){
        studentRepository.updateStudent(student.personId,
                student.getEmail(),
                student.getPassword(),
                student.getName(),
                student.getLastName(),
                student.getInterests(),
                student.getProfilePic(),
                student.isStudentStatus(),
                student.getDistricId(),
                student.getCantonId(),
                student.getProvinceId(),
                student.getCreateAt(),
                student.getUpdatedBy(),
                student.getUpdatedAt(),
                student.getRole(),
                student.getCarne(),
                "Update");
    }

    @Override
    public void serveStudentAccount(int studentId, int updatedBy, String action) {
        studentRepository.serveStudentRequest(studentId, updatedBy, action);
        Student student = studentRepository.getStudentById(studentId);
        if(action.equals("Accept")){
            emailService.sendMail("revistaparaiso123@gmail.com", student.getEmail(),
                    "Solicitud de Cuenta Acceptada",
                    "El Centro de Informática le informa que su cuenta ha sido acceptada");
        }else{
            emailService.sendMail("revistaparaiso123@gmail.com", student.getEmail(),
                    "Solicitud de Cuenta Rechazada",
                    "El Centro de Informática le informa que su cuenta ha sido rechazada, contacte al centro para más información");
        }

    }

    @Override
    public List<Student> getStudentstoAttend() {
        return studentRepository.getStudentsToAttend();
    }

    @Override
    public List<Student> getStudentsOff() {
        return studentRepository.getStudentsOff();
    }
}
