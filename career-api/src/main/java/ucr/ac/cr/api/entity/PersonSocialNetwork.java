package ucr.ac.cr.api.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name = "Person_Social_Network")
@NamedStoredProcedureQuery(name = "PersonSocialNetwork.getPersonSocialNetworkByPersonId",procedureName = "SelectPersonSocialNetworkById", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "@Person_Id", type = Integer.class)})

@NamedStoredProcedureQuery(name = "PersonSocialNetwork.insertPersonSocialNetworkSP",procedureName = "InsertPersonSocialNetwork", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Social_network_id", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Person_id", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "URL", type = String.class)})

@NamedStoredProcedureQuery(name = "PersonSocialNetwork.updatePersonSocialNetworkSP",procedureName = "UpdatePersonSocialNetwork", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Social_network_id", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Person_id", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "URL", type = String.class)})

@NamedStoredProcedureQuery(name = "PersonSocialNetwork.deletePersonSocialNetworkSP",procedureName = "DeletePersonSocialNetwork", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Social_network_id", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Person_id", type = Integer.class)})

public class PersonSocialNetwork {

	@EmbeddedId
	private PersonSocialNetworkPK personSocialNetworkPK;
	
	private String url;
	private String name;
	private byte[] socialNetworkPic;
	
	public PersonSocialNetwork() {
		
	}

	



	public PersonSocialNetwork(PersonSocialNetworkPK personSocialNetworkPK, String url, String name,
			byte[] socialNetworkPic) {
		
		this.personSocialNetworkPK = personSocialNetworkPK;
		this.url = url;
		this.name = name;
		this.socialNetworkPic = socialNetworkPic;
	}





	public PersonSocialNetworkPK getPersonSocialNetworkPK() {
		return personSocialNetworkPK;
	}


	public void setPersonSocialNetworkPK(PersonSocialNetworkPK personSocialNetworkPK) {
		this.personSocialNetworkPK = personSocialNetworkPK;
	}





	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getSocialNetworkPic() {
		return socialNetworkPic;
	}

	public void setSocialNetworkPic(byte[] socialNetworkPic) {
		this.socialNetworkPic = socialNetworkPic;
	}
	
	
}
