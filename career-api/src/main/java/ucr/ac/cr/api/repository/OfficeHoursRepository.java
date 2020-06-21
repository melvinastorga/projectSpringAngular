package ucr.ac.cr.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import ucr.ac.cr.api.entity.OfficeHours;

public interface OfficeHoursRepository extends JpaRepository<OfficeHours, Integer> {

	@Query(value = "Select_Office_Hours", nativeQuery = true)
	List<OfficeHours> getAllOfficeHours();
	
	@Query(value = "{ call Select_Office_Hours_By_Id(:Office_hours_id)}", nativeQuery = true)
	OfficeHours getOfficeHoursById(@Param("Office_hours_id") Integer officeHoursId);

	@Query(value = "{ call Select_Office_Hours_By_Course(:Professor_course_id)}", nativeQuery = true)
	List<OfficeHours> getOfficeHoursByCourse(@Param("Professor_course_id") Integer professorCourseId);
	
	@Procedure(name = "OfficeHours.insertOfficeHoursSP")
	void insertOfficeHoursSP(@Param("Start_Hour") String startHour, @Param("End_Hour") String endHour, @Param("Day") String day, @Param("Professor_course_id") Integer professorCourseId );

	@Procedure(name = "OfficeHours.updateOfficeHoursSP")
	void updateOfficeHoursSP(@Param("Office_hours_id") Integer officeHoursId , @Param("Start_Hour") String startHour, @Param("End_Hour") String endHour, @Param("Day") String day, @Param("Professor_course_id") Integer professorCourseId );
	
	@Procedure(name = "OfficeHours.deleteOfficeHoursSP")
	void deleteOfficeHoursSP(@Param("Office_hours_id") int officeHoursId);
}
