package ucr.ac.cr.api.service;


import ucr.ac.cr.api.entity.Admin;

public interface IAdmin {

     public void promoteProfessor(int professorId, int updatedBy);
     public Admin getAdmin();
}
