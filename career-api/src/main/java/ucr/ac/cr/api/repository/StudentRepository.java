package ucr.ac.cr.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import ucr.ac.cr.api.entity.Professor;
import ucr.ac.cr.api.entity.Student;
import ucr.ac.cr.api.entity.StudentDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value= "{ call [Get_Students_By_id](:Id)}", nativeQuery = true)
    Student getStudentById(@Param("Id") Integer id);

    //@Query(value= "Get_Students", nativeQuery = true)
    //List<Student> getAllStudent();

    @Query(value= "Get_All_Students", nativeQuery = true)
    List<Student> getAllStudent();

    @Procedure(name = "Student.insertStudent")
    void insertStudent(@Param("Person_id") Integer personId,
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
                       @Param("Create_at") Date createdAt,
                       @Param("Updated_by") Integer updatedBy,
                       @Param("Updated_at") Date updatedAt,
                       @Param("Role") String role,
                       @Param("Carne") String carne,
                       @Param("Action") String action);


    @Procedure(name = "Student.updateStudent")
    void updateStudent(@Param("Person_id") Integer personId,
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
                         @Param("Create_at") Date createdAt,
                         @Param("Updated_by") Integer updatedBy,
                         @Param("Updated_at") Date updatedAt,
                         @Param("Role") String role,
                         @Param("Carne") String carne,
                         @Param("Action") String action);

}

