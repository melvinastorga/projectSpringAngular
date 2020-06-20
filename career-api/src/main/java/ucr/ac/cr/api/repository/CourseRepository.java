package ucr.ac.cr.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import ucr.ac.cr.api.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	@Query(value = "Select_Course", nativeQuery = true)
	List<Course> getActiveCourses();
	
	@Query(value = "Select_Course_Off", nativeQuery = true)
	List<Course> getOffCourses();
	
	@Query(value = "{ call [Select_Course_By_Id](:Course_id)}", nativeQuery = true)
	Course getCourseById(@Param("Course_id") Integer courseId);
	
	@Procedure(name = "Course.insertCourseSP")
	void insertCourseSP(@Param("Credits") Integer credits, @Param("Code") String code, @Param("Name") String name, @Param("Term") Integer term, @Param("Description") String description  );

	@Procedure(name = "Course.updateCourseSP")
	void updateCourseSP(@Param("Course_id") Integer courseId ,@Param("Credits") Integer credits, @Param("Code") String code, @Param("Name") String name, @Param("Term") Integer term, @Param("Description") String description  );

	@Procedure(name = "Course.deleteteCourseSP")
	void deleteteCourseSP(@Param("Course_id") Integer courseId );
	
	@Procedure(name = "Course.activeCourseSP")
	void activeCourseSP(@Param("Course_id") Integer courseId );

}
