package ucr.ac.cr.api.service;

import ucr.ac.cr.api.entity.OfficeHours;
import ucr.ac.cr.api.entity.Student;
import ucr.ac.cr.api.entity.StudentDTO;

import java.util.List;

public interface IStudentService {
    List<Student> listAllStudent();
    Student getStudentById(int id);
    void insertStudent(Student officeHours);
    void updateStudent(Student officeHours);
    void serveStudentAccount(int studentId, int updatedBy, String action);
}
