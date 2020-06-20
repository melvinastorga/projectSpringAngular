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
@Table(name="Course")
@NamedStoredProcedureQuery(name = "Course.getActiveCourses", procedureName = "Select_Course")
@NamedStoredProcedureQuery(name = "Course.getOffCourses", procedureName = "Select_Course_Off")
@NamedStoredProcedureQuery(name = "Course.getCourseById",procedureName = "Select_Course_By_Id", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "@Course_id", type = Integer.class)})
@NamedStoredProcedureQuery(name = "Course.insertCourseSP",procedureName = "Insert_Course", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Credits", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Code", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Name", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Term", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Description", type = String.class)})

@NamedStoredProcedureQuery(name = "Course.updateCourseSP",procedureName = "Update_Course", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Course_id", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Credits", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Code", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Name", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Term", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Description", type = String.class)})

@NamedStoredProcedureQuery(name = "Course.deleteteCourseSP",procedureName = "Delete_Course", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Course_id", type = Integer.class)})

@NamedStoredProcedureQuery(name = "Course.activeCourseSP",procedureName = "Activate_Course", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Course_id", type = Integer.class)})

public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	private int credits;
	private String code;
	private String name;
	private int term;
	private boolean isActive;
	private String description;
	
	public Course() {
		
	}
	
	public Course(int courseId, int credits, String code, String name, int term, boolean isActive, String description) {
		
		this.courseId = courseId;
		this.credits = credits;
		this.code = code;
		this.name = name;
		this.term = term;
		this.isActive = isActive;
		this.description = description;
	}




	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
