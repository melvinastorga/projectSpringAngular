package examen.api.entity;

import javax.persistence.*;

@Entity
@Table(name="Major")

@NamedStoredProcedureQuery(name = "Major.insertMajor", procedureName = "insertUpdateMajor", parameters = {
@StoredProcedureParameter(mode = ParameterMode.IN, name = "MajorId", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "MajorName", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "SemestersQuantity", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Action", type = String.class)})


@NamedStoredProcedureQuery(name = "Major.updateMajor", procedureName = "insertUpdateMajor", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "MajorId", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "MajorName", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "SemestersQuantity", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Action", type = String.class)})

@NamedStoredProcedureQuery(name = "Major.getAllMajors", procedureName = "getMajors")

@NamedStoredProcedureQuery(name = "Major.getMajorById",procedureName = "getMajorById", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "MajorId", type = Integer.class)})

@NamedStoredProcedureQuery(name = "Major.deleteMajor",procedureName = "deleteMajor", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "MajorId", type = Integer.class)})


public class Major {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int majorId;
	private String majorName;
	private int semesterQuantity;
	
	public Major() {
		
	}

	public Major(int majorId, String majorName, int semestersQuantity) {
		this.majorId = majorId;
		this.majorName = majorName;
		this.semesterQuantity = semestersQuantity;
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

	public int getSemesterQuantity() {
		return semesterQuantity;
	}

	public void setSemesterQuantity(int semesterQuantity) {
		this.semesterQuantity = semesterQuantity;
	}
}