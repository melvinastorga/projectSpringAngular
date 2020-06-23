package ucr.ac.cr.api.entity;

import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;


public class UserModel {

    public Professor professor;

    public Student student;

    public LocationNames locationNames;

    public UserModel() {
    }

    public UserModel(Professor professor, Student student, LocationNames locationNames) {
        this.professor = professor;
        this.student = student;
        this.locationNames = locationNames;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocationNames getLocationNames() {
        return locationNames;
    }

    public void setLocationNames(LocationNames locationNames) {
        this.locationNames = locationNames;
    }
}
