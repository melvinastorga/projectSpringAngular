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
@Table(name = "Person")
@NamedStoredProcedureQuery(name = "LoginTest.getLoginTest",procedureName = "SelectLogin", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Email", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Password", type = String.class)})

public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personId;
	private String role;
	private boolean status;
	
	
	public Login() {
	
	}

	public Login(int personId, String role, boolean status) {
		
		this.personId = personId;
		this.role = role;
		this.status = status;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
