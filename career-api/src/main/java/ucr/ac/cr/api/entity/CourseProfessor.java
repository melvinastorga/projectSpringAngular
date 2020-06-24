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
@NamedStoredProcedureQuery(name = "CourseProfessor.getProfessorByCourse",procedureName = "Select_Professors_By_Course", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "@Course_id", type = Integer.class)})

public class CourseProfessor {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int professorCourseId;
	
	private int courseId;
	private int professorId;
	private String professorName;
	private String lastName;
	private String email;
	private String interests;
	private String especiality;
	
	public CourseProfessor() {
	
	}

	public CourseProfessor(int professorCourseId, int courseId, int professorId, String professorName, String lastName,
			String email, String interest, String especiality) {
		
		this.professorCourseId = professorCourseId;
		this.courseId = courseId;
		this.professorId = professorId;
		this.professorName = professorName;
		this.lastName = lastName;
		this.email = email;
		this.interests = interests;
		this.especiality = especiality;
	}

	public int getProfessorCourseId() {
		return professorCourseId;
	}

	public void setProfessorCourseId(int professorCourseId) {
		this.professorCourseId = professorCourseId;
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

	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInterest() {
		return interests;
	}

	public void setInterest(String interests) {
		this.interests = interests;
	}

	public String getEspeciality() {
		return especiality;
	}

	public void setEspeciality(String especiality) {
		this.especiality = especiality;
	}
	
	
	
}


	

	