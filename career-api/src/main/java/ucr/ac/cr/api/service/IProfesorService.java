package ucr.ac.cr.api.service;

import ucr.ac.cr.api.entity.Professor;

import java.util.List;

public interface IProfesorService {

    public Professor getProfessorById(int id);
    public void insertProfessor(Professor professor);
    public void updateProfessor(Professor professor);
    public List<Professor> getAllProfessor();
    public List<Professor> getProfessorsOff();
}
