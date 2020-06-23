package ucr.ac.cr.api.service.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucr.ac.cr.api.entity.Appointment;
import ucr.ac.cr.api.repository.AppointmentRepository;
import ucr.ac.cr.api.repository.CourseRepository;
import ucr.ac.cr.api.service.IAppointmentService;
import ucr.ac.cr.api.service.ICourseService;

@Service
@Transactional
public class AppointmentService implements IAppointmentService {

	@Autowired
	private AppointmentRepository repoAppointment;
	
	@Override
	public List<Appointment> GetAppointmentByIdProfessorCourse(int professorCourseId) {
		
		return repoAppointment.getAppointmentByProfessorCourse(professorCourseId);
	}

	@Override
	public List<Appointment> getAppointmentByProfessorCourseAccepted(int professorCourseId) {
		
		return repoAppointment.getAppointmentByProfessorCourseAccepted(professorCourseId);
	}

	@Override
	public List<Appointment> getAppointmentByProfessorCourseHolded(int professorCourseId) {
		
		return repoAppointment.getAppointmentByProfessorCourseHolded(professorCourseId);
	}


	@Override
	public Appointment getAppointmentById(int appointmentId) {
		
		return repoAppointment.getAppointmentById(appointmentId);
	}
	
	@Override
	public List<Appointment> getAppointmentByProfessorCourseRefused(int professorCourseId) {
		
		return repoAppointment.getAppointmentByProfessorCourseRefused(professorCourseId);
	}

	@Override
	public void insertAppointmentSP(Appointment appointment) {
		repoAppointment.insertAppointmentSP(appointment.getProfessorCourseId(), appointment.getStudentId(), appointment.getStartHour(), appointment.getEndHour(), appointment.getDay());
	}


	@Override
	public void updateAppointmentSP(Appointment appointment) {
		
		repoAppointment.updateAppointmentSP(appointment.getAppointmentId() ,appointment.getProfessorCourseId(), appointment.getStudentId(), appointment.getStartHour(), appointment.getEndHour(), appointment.getDay(), appointment.getStatus());
	}

	@Override
	public void acceptAppointmentSP(Appointment appointment) {
		repoAppointment.acceptAppointmentSP(appointment.getAppointmentId());
	}

	@Override
	public void refuseAppointmentSP(Appointment appointment) {
		repoAppointment.refuseAppointmentSP(appointment.getAppointmentId());
	}

	@Override
	public void deleteAppointmentSP(int appointmentId) {
		repoAppointment.deleteAppointmentSP(appointmentId);
	}

	
}
