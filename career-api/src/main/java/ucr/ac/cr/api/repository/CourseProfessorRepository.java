package ucr.ac.cr.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ucr.ac.cr.api.entity.CourseProfessor;

@Repository
public interface CourseProfessorRepository extends JpaRepository<CourseProfessor, Integer>{

	
	@Query(value = "{ call Select_Professors_By_Course(:Course_id)}", nativeQuery = true)
	List<CourseProfessor> getProfessorByCourse(@Param("Course_id") Integer courseId);
	
}
