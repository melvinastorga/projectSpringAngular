package ucr.ac.cr.api.service;

public interface IPerson {

    public void desactivatePerson(int id, int updatedBy);
    public void activatePerson(int id, int updatedBy);
}
