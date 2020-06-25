package ucr.ac.cr.api.service;

import ucr.ac.cr.api.entity.President;

public interface IPresident {

    public void promoteStudent(int studentId, int updatedBy);
    public President getPresident();

}
