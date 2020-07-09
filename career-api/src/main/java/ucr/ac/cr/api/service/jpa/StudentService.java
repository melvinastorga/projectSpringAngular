package ucr.ac.cr.api.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.api.entity.Student;
import ucr.ac.cr.api.repository.StudentRepository;
import ucr.ac.cr.api.service.IStudentService;

import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.List;

@Service
@Transactional
public class StudentService implements IStudentService {

    long millis=System.currentTimeMillis();
    java.sql.Date date=new java.sql.Date(millis);

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SendMailService emailService;

    @Override
    public List<Student> listAllStudent(){
        return studentRepository.getAllStudent();
    }

    @Override
    public Student getStudentById(int id) {

        return studentRepository.getStudentById(id);
    }

    @Override
    public void insertStudent(Student student) throws UnsupportedEncodingException {

        student.setProfilePic(stringToByte(student.imgString));

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
                date,
                student.personId,
                date,
                "Student",
                student.getCarne(),
                "Insert");
    }

    @Override
    public void updateStudent(Student student){
        studentRepository.updateStudent(student.getPersonId(),
                student.getEmail(),
                student.getPassword(),
                student.getName(),
                student.getLastName(),
                student.getInterests(),
                student.getProfilePic(),
                true,
                student.getDistricId(),
                student.getCantonId(),
                student.getProvinceId(),
                date,
                student.getPersonId(),
                date,
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

    public byte[] stringToByte(String string) throws UnsupportedEncodingException {
        byte[] name = Base64.getEncoder().encode(string.getBytes());
        byte[] decodedString = Base64.getDecoder().decode(new String(name).getBytes("UTF-8"));
        System.out.println(new String(decodedString));
        return name;
    }

    public String byteToString (byte[] arrayString) throws UnsupportedEncodingException {
        String decoded = new String(new String(arrayString, "UTF-8"));
        return decoded;
    }
}
