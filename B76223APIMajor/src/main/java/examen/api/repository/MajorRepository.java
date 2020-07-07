package examen.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import examen.api.entity.Major;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface MajorRepository extends JpaRepository<Major, Integer>{

	@Query(value = "getMajors", nativeQuery = true)
	List<Major> getAllMajors();

	@Query(value = "{ call [getMajorById](:MajorId)}", nativeQuery = true)
	Major getMajorById(@Param("MajorId") Integer majorId);

	@Procedure(name = "Major.deleteMajor")
	void deleteMajor(@Param("MajorId") int majorId);

	@Procedure(name = "Major.insertMajor")
	void insertMajor(@Param("MajorId") Integer majorId,
						 @Param("MajorName") String majorName,
						 @Param("SemestersQuantity") Integer semesters,
						 @Param("Action") String action);

	@Procedure(name = "Major.updateMajor")
	void updateMajor(@Param("MajorId") Integer majorId,
						 @Param("MajorName") String majorName,
						 @Param("SemestersQuantity") Integer semesters,
						 @Param("Action") String action);
}
