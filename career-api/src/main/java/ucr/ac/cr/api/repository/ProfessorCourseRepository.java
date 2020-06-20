package ucr.ac.cr.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import ucr.ac.cr.api.entity.Course;
import ucr.ac.cr.api.entity.ProfessorCourse;

public interface ProfessorCourseRepository extends JpaRepository<ProfessorCourse, Integer> {

	@Query(value = "{ call Select_All_Course_From_Professor(:Professor_id)}", nativeQuery = true)
	ProfessorCourse getCourseByProfessor(@Param("Professor_id") Integer professorId);
	
	//@Procedure(name = "ProfessorCourse.getCourseByProfessor")
	//ProfessorCourse getCourseByProfessor(@Param("Professor_id") Integer professorId);
}
