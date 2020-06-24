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
@Table(name = "Professor_Course")
@NamedStoredProcedureQuery(name = "ProfessorCourse.getCourseByProfessor",procedureName = "Select_All_Course_From_Professor", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "@Professor_id", type = Integer.class)})

@NamedStoredProcedureQuery(name = "ProfessorCourse.insertUpdateProfessorCourseSP",procedureName = "Insert_Update_Professor_To_Course", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Professor_id", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Course_id", type = Integer.class)})

@NamedStoredProcedureQuery(name = "ProfessorCourse.deleteProfessorCourseSP",procedureName = "Delete_Course_Professor", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Professor_course_id", type = Integer.class)})


public class ProfessorCourse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int professorCourseId;
	private int courseId;
	private int professorId;
	//private String professorName;
	private String courseName;
	//private String lastName;
	//private String email;
	//private String interest;
	//private String especiality;
	private String code;
	private int credits;
	private int term;
	
	public ProfessorCourse() {
	
	}

	public ProfessorCourse(int profesorCourseId, int courseId, int professorId, String professorName, String courseName,
			String lastName, String email, String interest, String especiality, String code, int credits, int term) {
		
		this.professorCourseId = profesorCourseId;
		this.courseId = courseId;
		this.professorId = professorId;
		//this.professorName = professorName;
		this.courseName = courseName;
		//this.lastName = lastName;
		//this.email = email;
		//this.interest = interest;
		//this.especiality = especiality;
		this.code = code;
		this.credits = credits;
		this.term = term;
	}

	public int getProfessorCourseId() {
		return professorCourseId;
	}

	public void setProfesorCourseId(int profesorCourseId) {
		this.professorCourseId = profesorCourseId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	//public String getProfessorName() {
	//return professorName;
	//}

	//public void setProfessorName(String professorName) {
	//this.professorName = professorName;
	//}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	//public String getLastName() {
	//return lastName;
	//}

	//public void setLastName(String lastName) {
	//this.lastName = lastName;
	//}

	//public String getEmail() {
	//return email;
	//}

	//public void setEmail(String email) {
	//this.email = email;
	//}

	//public String getInterest() {
	//return interest;
	//}

	//public void setInterest(String interest) {
	//this.interest = interest;
	//}

	//public String getEspeciality() {
	//return especiality;
	//}

	//public void setEspeciality(String especiality) {
	//this.especiality = especiality;
	//}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}
	
	
	
}