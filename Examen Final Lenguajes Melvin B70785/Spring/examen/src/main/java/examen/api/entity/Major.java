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
@NamedStoredProcedureQuery(name = "Major.getAllMajors", procedureName = "getAllMajors")
@NamedStoredProcedureQuery(name = "Major.getLastMajor", procedureName = "getLastId")
@NamedStoredProcedureQuery(name = "Major.getMajorById",procedureName = "get_Major_By_Id", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "@Major_id", type = Integer.class)})
@NamedStoredProcedureQuery(name = "Major.deleteMajor",procedureName = "delete_Major", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "Major_id", type = Integer.class)})



@NamedStoredProcedureQuery(name = "Major.updateMajor", procedureName = "updateMajor", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Major_id", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Major_name", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Major_description", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Semesters", type = Integer.class),})

@NamedStoredProcedureQuery(name = "Major.insertMajor", procedureName = "insertMajor", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Major_name", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Major_description", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Semesters", type = Integer.class),})

public class Major {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int majorId;
	private String majorName;
	private String majorDescription;
	private int semesters;
	
	public Major() {
		
	}

	public Major(int majorId, String majorName, String majorDescription, int semesters) {
		
		this.majorId = majorId;
		this.majorName = majorName;
		this.majorDescription = majorDescription;
		this.semesters = semesters;
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

	public String getMajorDescription() {
		return majorDescription;
	}

	public void setMajorDescription(String majorDescription) {
		this.majorDescription = majorDescription;
	}

	public int getSemesters() {
		return semesters;
	}

	public void setSemesters(int semesters) {
		this.semesters = semesters;
	}

	
	
	
}