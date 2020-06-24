package ucr.ac.cr.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ucr.ac.cr.api.entity.Course;
import ucr.ac.cr.api.entity.ProfessorCourse;

@Repository
public interface ProfessorCourseRepository extends JpaRepository<ProfessorCourse, Integer> {

	@Query(value = "{ call Select_All_Course_From_Professor(:Professor_id)}", nativeQuery = true)
	List<ProfessorCourse> getCourseByProfessor(@Param("Professor_id") Integer professorId);
	
	
	@Procedure(name = "ProfessorCourse.insertUpdateProfessorCourseSP")
	void insertUpdateProfessorCourseSP(@Param("Professor_id") Integer professorId, @Param("Course_id") Integer courseId);

	@Procedure(name = "ProfessorCourse.deleteProfessorCourseSP")
	void deleteProfessorCourseSP(@Param("Professor_course_id") Integer professorCourseId);

	
	
	//@Procedure(name = "ProfessorCourse.getCourseByProfessor")
	//ProfessorCourse getCourseByProfessor(@Param("Professor_id") Integer professorId);
}
