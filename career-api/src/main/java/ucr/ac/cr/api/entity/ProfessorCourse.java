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
public class ProfessorCourse {

	private int professorId;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int profesorCourseId;
	private int courseId;
	private int credits;
	private String code;
	private String name;
	private int term;
	
	public ProfessorCourse() {

	}

	public ProfessorCourse(int profesorId, int profesorCourseId, int courseId, int credits, String code,
			String name, int term) {
		
		this.profesorCourseId = profesorCourseId;
		this.professorId = profesorId;
		this.courseId = courseId;
		this.credits = credits;
		this.code = code;
		this.name = name;
		this.term = term;
	}
	

	public int getProfesorCourseId() {
		return profesorCourseId;
	}

	public void setProfesorCourseId(int profesorCourseId) {
		this.profesorCourseId = profesorCourseId;
	}

	public int getProfesorId() {
		return professorId;
	}

	public void setProfesorId(int profesorId) {
		this.professorId = profesorId;
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
	
	
	
}
