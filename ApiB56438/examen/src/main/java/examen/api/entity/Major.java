package examen.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name="Major")
@NamedStoredProcedureQuery(name = "Major.getAllMajors", procedureName = "getMajor")
@NamedStoredProcedureQuery(name = "Major.getMajorById",procedureName = "getMajorById", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "@majorId", type = Integer.class)})
@NamedStoredProcedureQuery(name = "Major.deleteMajor",procedureName = "delete_Major", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "majorId", type = Integer.class)})

@NamedStoredProcedureQuery(name = "Major.insertMajor", procedureName = "insertUpdateMajor", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "majorId", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "majorName", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "semester", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Action", type = String.class)})


@NamedStoredProcedureQuery(name = "Major.updateMajor", procedureName = "insertUpdateMajor", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "majorId", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "majorName", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "semester", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Action", type = String.class)})

public class Major {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int majorId;
	private String majorName;
	private int semester;
	
	public Major() {
		
	}

	public Major(int majorId, String majorName, String majorDescription, int semesters) {
		
		this.majorId = majorId;
		this.majorName = majorName;
		this.semester = semester;
	}

	public int getMajorId() {
		return majorId;
	}

	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	
	
	
}