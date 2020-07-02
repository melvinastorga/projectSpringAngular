package examen.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import examen.api.entity.Major;

public interface MajorRepository extends JpaRepository<Major, Integer>{

	@Query(value = "getMajor", nativeQuery = true)
	List<Major> getMajor();
	
	@Query(value = "{ call [getMajorById](:majorId)}", nativeQuery = true)
	Major getMajorById(@Param("majorId") Integer majorId);
	
	@Procedure(name = "Major.deleteMajor")
	void deleteMajor(@Param("majorId") int majorId);
	
	@Procedure(name = "Major.insertMajor")
	void insertMajor(@Param("majorId") Integer majorId,
						 @Param("majorName") String majorName,
						 @Param("semester") int semester,
						 @Param("Action") String action);

	@Procedure(name = "Major.updateMajor")
	void updateMajor(@Param("majorId") Integer majorId,
						 @Param("majorName") String majorName,
						 @Param("semester") int semester,
						 @Param("Action") String action);
}
