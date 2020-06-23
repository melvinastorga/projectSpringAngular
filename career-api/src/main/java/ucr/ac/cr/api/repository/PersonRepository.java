package ucr.ac.cr.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import ucr.ac.cr.api.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Procedure(name = "Person.desactivatePerson")
    public void desactivatePerson(@Param("Person_id") Integer personId,
                                  @Param("Update_by") Integer updatedBy);

    @Procedure(name = "Person.activatePerson")
    public void activatePerson(@Param("Person_id") Integer personId,
                                  @Param("Update_by") Integer updatedBy);

}
