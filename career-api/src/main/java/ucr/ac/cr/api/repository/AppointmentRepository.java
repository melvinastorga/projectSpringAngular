package ucr.ac.cr.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ucr.ac.cr.api.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	@Query(value = "{ call Select_All_Appointment(:Professor_course_id)}", nativeQuery = true)
	List<Appointment> getAppointmentByProfessorCourse(@Param("Professor_course_id") Integer professorCourseId);
	
	@Query(value = "{ call Select_All_Accepted_Appointment(:Professor_course_id)}", nativeQuery = true)
	List<Appointment> getAppointmentByProfessorCourseAccepted(@Param("Professor_course_id") Integer professorCourseId);
	
	@Query(value = "{ call Select_All_Hold_Appointment(:Professor_course_id)}", nativeQuery = true)
	List<Appointment> getAppointmentByProfessorCourseHolded(@Param("Professor_course_id") Integer professorCourseId);
	
	@Query(value = "{ call Select_All_Refused_Appointment(:Professor_course_id)}", nativeQuery = true)
	List<Appointment> getAppointmentByProfessorCourseRefused(@Param("Professor_course_id") Integer professorCourseId);
	
	@Query(value = "{ call Select_Appointment_By_Id(:Appointment_id)}", nativeQuery = true)
	Appointment getAppointmentById(@Param("Appointment_id") Integer appointmentId);
	
	@Procedure(name = "Appointment.insertAppointmentSP")
	void insertAppointmentSP(@Param("Professor_course_id") Integer professorCourseId, @Param("Student_id") Integer studentId, @Param("Start_hour") String startHour, @Param("End_hour") String endHour, @Param("Day") String day );

	@Procedure(name = "Appointment.updateAppointmentSP")
	void updateAppointmentSP(@Param("Appointment_id") Integer appointmentId ,@Param("Professor_course_id") Integer professorCourseId, @Param("Student_id") Integer studentId, @Param("Start_hour") String startHour, @Param("End_hour") String endHour, @Param("Day") String day, @Param("Status") String status );

	@Procedure(name = "Appointment.acceptAppointmentSP")
	void acceptAppointmentSP(@Param("Appointment_id") Integer appointmentId);

	@Procedure(name = "Appointment.refuseAppointmentSP")
	void refuseAppointmentSP(@Param("Appointment_id") Integer appointmentId);

	@Procedure(name = "Appointment.deleteAppointmentSP")
	void deleteAppointmentSP(@Param("Appointment_id") int appointmentId);
	
}
