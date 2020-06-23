package ucr.ac.cr.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ucr.ac.cr.api.entity.Professor;

import java.util.Date;
import java.util.List;


public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

@Query(value= "{call Get_Professor_By_Id(:Id)}", nativeQuery = true)
   Professor getProfessorById(@Param("Id") Integer id);

//@Procedure(name= "Professor.getProfessorById")
    //Professor getProfessorById(@Param("Id") Integer id);

@Query(value= "Get_Professors", nativeQuery = true)
    List<Professor> getAllProfessor();

@Procedure(name = "Professor.insertProfessor")
    void insertProfessor(@Param("Person_id") Integer personId,
                         @Param("Email") String email,
                         @Param("Password") String password,
                         @Param("Name") String name,
                         @Param("Last_name") String lastName,
                         @Param("Interests") String interests,
                         @Param("Profile_pic") byte[] profilePic,
                         @Param("Status") Boolean status,
                         @Param("Distric_id") Integer districId,
                         @Param("Canton_id") Integer cantonId,
                         @Param("Province_id") Integer provinceId,
                         @Param("Created_by") Integer createdBy,
                         @Param("Create_at") Date createdAt,
                         @Param("Updated_by") Integer updatedBy,
                         @Param("Updated_at") Date updatedAt,
                         @Param("Role") String role,
                         @Param("Especiality") String especiality,
                         @Param("Action") String action);


    @Procedure(name = "Professor.updateProfessor")
    void updateProfessor(@Param("Person_id") Integer personId,
                         @Param("Email") String email,
                         @Param("Password") String password,
                         @Param("Name") String name,
                         @Param("Last_name") String lastName,
                         @Param("Interests") String interests,
                         @Param("Profile_pic") byte[] profile_pic,
                         @Param("Status") Boolean status,
                         @Param("Distric_id") Integer districId,
                         @Param("Canton_id") Integer cantonId,
                         @Param("Province_id") Integer provinceId,
                         @Param("Created_by") Integer createdBy,
                         @Param("Create_at") Date createdAt,
                         @Param("Updated_by") Integer updatedBy,
                         @Param("Updated_at") Date updatedAt,
                         @Param("Role") String role,
                         @Param("Especiality") String especiality,
                         @Param("Action") String action);

    @Procedure(name = "Professor.insertProfessor")
    void insertProfessor(@Param("Person_id") Integer personId);

}