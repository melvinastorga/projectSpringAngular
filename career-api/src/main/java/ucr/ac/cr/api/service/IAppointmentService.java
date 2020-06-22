package ucr.ac.cr.api.service;

import java.util.List;

import ucr.ac.cr.api.entity.Appointment;
import ucr.ac.cr.api.entity.Course;

public interface IAppointmentService {

	List<Appointment> GetAppointmentByIdProfessorCourse(int professorCourseId);
	List<Appointment> getAppointmentByProfessorCourseAccepted(int professorCourseId);
	List<Appointment> getAppointmentByProfessorCourseHolded(int professorCourseId);
	List<Appointment> getAppointmentByProfessorCourseRefused(int professorCourseId);
	Appointment getAppointmentById(int appointmentId);
	void insertAppointmentSP(Appointment appointment);
	void updateAppointmentSP(Appointment appointment);
	void acceptAppointmentSP(Appointment appointment);
	void refuseAppointmentSP(Appointment appointment);
	void deleteAppointmentSP(int appointmentId);
}
