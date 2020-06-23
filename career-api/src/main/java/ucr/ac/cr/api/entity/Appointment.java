package ucr.ac.cr.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name = "Appointment")

@NamedStoredProcedureQuery(name = "Appointment.getAppointmentByProfessorCourse",procedureName = "Select_All_Appointment", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "@Professor_course_id", type = Integer.class)})
@NamedStoredProcedureQuery(name = "Appointment.getAppointmentByProfessorCourseAccepted",procedureName = "Select_All_Accepted_Appointment", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "@Professor_course_id", type = Integer.class)})
@NamedStoredProcedureQuery(name = "Appointment.getAppointmentByProfessorCourseHolded",procedureName = "Select_All_Hold_Appointment", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "@Professor_course_id", type = Integer.class)})
@NamedStoredProcedureQuery(name = "Appointment.getAppointmentByProfessorCourseRefused",procedureName = "Select_All_Hold_Appointment", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "@Professor_course_id", type = Integer.class)})
@NamedStoredProcedureQuery(name = "Appointment.getAppointmentById",procedureName = "Select_Appointment_By_Id", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "@Appointment_id", type = Integer.class)})

@NamedStoredProcedureQuery(name = "Appointment.insertAppointmentSP",procedureName = "Create_Appointment", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Professor_course_id", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Student_id", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Start_hour", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "End_hour", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Day", type = String.class)})

@NamedStoredProcedureQuery(name = "Appointment.updateAppointmentSP",procedureName = "Update_Appointment", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Appointment_id", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Professor_course_id", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Student_id", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Start_hour", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "End_hour", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Day", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Status", type = String.class)})

@NamedStoredProcedureQuery(name = "Appointment.acceptAppointmentSP",procedureName = "Accept_Appointment", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Appointment_id", type = Integer.class)})

@NamedStoredProcedureQuery(name = "Appointment.refuseAppointmentSP",procedureName = "Refuse_Appointment", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Appointment_id", type = Integer.class)})

@NamedStoredProcedureQuery(name = "Appointment.deleteAppointmentSP",procedureName = "Delete_Appointment", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Appointment_id", type = Integer.class)})

public class Appointment {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int appointmentId;
private int professorCourseId;
private int studentId;
private String startHour;
private String endHour;
private String day;
private String status;

public Appointment() {
	
}

public Appointment(int appointmentId, int professorCourseId, int studentId, String startHour, String endHour,
		String day, String status) {
	
	this.appointmentId = appointmentId;
	this.professorCourseId = professorCourseId;
	this.studentId = studentId;
	this.startHour = startHour;
	this.endHour = endHour;
	this.day = day;
	this.status = status;
}

public int getAppointmentId() {
	return appointmentId;
}

public void setAppointmentId(int appointmentId) {
	this.appointmentId = appointmentId;
}

public int getProfessorCourseId() {
	return professorCourseId;
}

public void setProfessorCourseId(int professorCourseId) {
	this.professorCourseId = professorCourseId;
}

public int getStudentId() {
	return studentId;
}

public void setStudentId(int studentId) {
	this.studentId = studentId;
}

public String getStartHour() {
	return startHour;
}

public void setStartHour(String startHour) {
	this.startHour = startHour;
}

public String getEndHour() {
	return endHour;
}

public void setEndHour(String endHour) {
	this.endHour = endHour;
}

public String getDay() {
	return day;
}

public void setDay(String day) {
	this.day = day;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}



}
