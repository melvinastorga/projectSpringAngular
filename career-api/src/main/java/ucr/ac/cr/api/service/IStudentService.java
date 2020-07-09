package ucr.ac.cr.api.service;

import ucr.ac.cr.api.entity.OfficeHours;
import ucr.ac.cr.api.entity.Student;
import ucr.ac.cr.api.entity.StudentDTO;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface IStudentService {
    List<Student> listAllStudent();
    Student getStudentById(int id) throws UnsupportedEncodingException;
    void insertStudent(Student officeHours) throws UnsupportedEncodingException;
    void updateStudent(Student officeHours);
    void serveStudentAccount(int studentId, int updatedBy, String action);
    List<Student> getStudentstoAttend();
    List<Student> getStudentsOff();
}
