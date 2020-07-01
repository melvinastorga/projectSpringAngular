package examen.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import examen.api.entity.Major;

public interface MajorRepository extends JpaRepository<Major, Integer>{

	@Query(value = "get_majors", nativeQuery = true)
	List<Major> get_majors();
	
	@Query(value = "{ call [get_major](:major_id)}", nativeQuery = true)
	Major get_major(@Param("major_id") Integer major_id);
	
	@Procedure(name = "Major.delete_major")
	void delete_major(@Param("major_id") int major_id);
	
	
	@Procedure(name = "Major.insert_major")
   void insert_major(@Param("major_id") Integer major_id,
					 @Param("major") String major,
						 @Param("semesters") int semesters,
						 @Param("action") String action);

	@Procedure(name = "Major.update_major")
	void update_major(@Param("major_id") Integer major_id,
						 @Param("major") String major,
						 @Param("semesters") int semesters,
						 @Param("action") String action);
}
