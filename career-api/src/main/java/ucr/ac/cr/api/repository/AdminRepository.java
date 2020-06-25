package ucr.ac.cr.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import ucr.ac.cr.api.entity.Admin;
import ucr.ac.cr.api.entity.President;

public interface AdminRepository extends JpaRepository<Admin,Integer> {

    @Query(value= "{call Get_Admin}", nativeQuery = true)
    Admin getAdmin();

    @Procedure(name= "Admin.promoteProfessor")
    void promoteProfessor(@Param("Professor_id") Integer studentId,
                               @Param("Update_by") Integer updatedBy);
}
