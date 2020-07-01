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
@NamedStoredProcedureQuery(name = "Major.delete_major",procedureName = "delete_major", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "major_id", type = Integer.class)})
@NamedStoredProcedureQuery(name = "Major.get_major",procedureName = "get_major", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "@major_id", type = Integer.class)})
@NamedStoredProcedureQuery(name = "Major.get_majors", procedureName = "get_majors")

@NamedStoredProcedureQuery(name = "Major.update_major", procedureName = "insert_update_major", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "major_id", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "major", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "semesters", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "action", type = String.class)})


@NamedStoredProcedureQuery(name = "Major.insert_major", procedureName = "insert_update_major", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "major_id", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "major", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "semesters", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "action", type = String.class)})



public class Major {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int major_id;
	private String major;
	private int semesters;
	
	public Major() {
		
	}



	public Major(int major_id, String major , int semesters) {
		
		this.major_id= major_id;
		this.major = major;
		this.semesters = semesters;
	}

	public int getMajor_id() {
		return major_id;
	}

	public void setMajor_id(int major_id) {
		this.major_id = major_id;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getSemesters() {
		return semesters;
	}

	public void setSemesters(int semesters) {
		this.semesters = semesters;
	}

}