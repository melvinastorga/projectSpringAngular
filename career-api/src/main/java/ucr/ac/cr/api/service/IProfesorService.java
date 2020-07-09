package ucr.ac.cr.api.service;

import ucr.ac.cr.api.entity.Professor;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface IProfesorService {

    public Professor getProfessorById(int id);
    public void insertProfessor(Professor professor) throws UnsupportedEncodingException;
    public void updateProfessor(Professor professor) throws UnsupportedEncodingException;
    public List<Professor> getAllProfessor();
    public List<Professor> getProfessorsOff();
}
