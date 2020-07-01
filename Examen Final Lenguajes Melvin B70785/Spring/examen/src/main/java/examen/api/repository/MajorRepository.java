package examen.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import examen.api.entity.Major;

public interface MajorRepository extends JpaRepository<Major, Integer>{

	@Query(value = "getAllMajors", nativeQuery = true)
	List<Major> getAllMajors();
	
	@Query(value = "getLastId", nativeQuery = true)
	Major getLastMajor();
	
	@Query(value = "{ call [get_Major_By_Id](:Major_id)}", nativeQuery = true)
	Major getMajorById(@Param("Major_id") Integer majorId);
	
	@Procedure(name = "Major.deleteMajor")
	void deleteMajor(@Param("Major_id") int majorId);
	
	@Procedure(name = "Major.insertMajor")
	void insertMajor(
						 @Param("Major_name") String majorName,
						 @Param("Major_description") String majorDescription,
						 @Param("Semesters") int semesters);

	@Procedure(name = "Major.updateMajor")
	void updateMajor(@Param("Major_id") Integer majorId,
						 @Param("Major_name") String majorName,
						 @Param("Major_description") String majorDescription,
						 @Param("Semesters") int semesters);
	
	
}
