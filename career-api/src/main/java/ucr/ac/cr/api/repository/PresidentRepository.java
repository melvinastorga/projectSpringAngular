package ucr.ac.cr.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import ucr.ac.cr.api.entity.President;
import ucr.ac.cr.api.entity.Professor;

public interface PresidentRepository extends JpaRepository<President, Integer> {

    @Query(value= "{call Get_President}", nativeQuery = true)
    President getPresident();

    @Procedure(name= "President.promoteStudent")
    void promoteStudent(@Param("Student_id") Integer studentId,
                        @Param("Update_by") Integer updatedBy);
}
