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
@Table(name = "Office_Hours")
@NamedStoredProcedureQuery(name = "OfficeHours.getAllOfficeHours", procedureName = "Select_Office_Hours")
@NamedStoredProcedureQuery(name = "OfficeHours.getOfficeHoursById",procedureName = "Select_Office_Hours_By_Id", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "@Office_hours_id", type = Integer.class)})
@NamedStoredProcedureQuery(name = "OfficeHours.getOfficeHoursByCourse",procedureName = "Select_Office_Hours_By_Course", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "@Professor_course_id", type = Integer.class)})

@NamedStoredProcedureQuery(name = "OfficeHours.deleteOfficeHoursSP",procedureName = "Delete_Office_Hours", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "Office_hours_id", type = Integer.class)})

@NamedStoredProcedureQuery(name = "OfficeHours.insertOfficeHoursSP",procedureName = "Insert_Office_Hours", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Start_Hour", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "End_Hour", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Day", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Professor_course_id", type = Integer.class)})

@NamedStoredProcedureQuery(name = "OfficeHours.updateOfficeHoursSP",procedureName = "Update_Office_Hours", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Office_hours_id", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Start_Hour", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "End_Hour", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Day", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Professor_course_id", type = Integer.class)})


public class OfficeHours {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int officeHoursId;
private String day;
private String startHour;
private String endHour;
private int professorCourseId;


public OfficeHours() {
	
}


public OfficeHours(int officeHoursId, String day, String startHour, String endHour, int professorCourseId) {
	
	this.officeHoursId = officeHoursId;
	this.day = day;
	this.startHour = startHour;
	this.endHour = endHour;
	this.professorCourseId = professorCourseId;
}


public int getOfficeHoursId() {
	return officeHoursId;
}


public void setOfficeHoursId(int officeHoursId) {
	this.officeHoursId = officeHoursId;
}


public String getDay() {
	return day;
}


public void setDay(String day) {
	this.day = day;
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


public int getProfessorCourseId() {
	return professorCourseId;
}


public void setProfessorCourseId(int professorCourseId) {
	this.professorCourseId = professorCourseId;
}





}
