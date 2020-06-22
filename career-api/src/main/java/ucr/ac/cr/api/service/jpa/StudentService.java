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
                student.isStudentStatus(),
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
                "Insert");
    }
}
