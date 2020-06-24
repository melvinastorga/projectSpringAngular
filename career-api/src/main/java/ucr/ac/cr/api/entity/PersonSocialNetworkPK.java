package ucr.ac.cr.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PersonSocialNetworkPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="Person_Id")
	private int personId;
	@Column(name="Social_Network_Id")
	private int socialNetworkId;
	
	
	
	
	public PersonSocialNetworkPK() {
		
	}

	
	
	public PersonSocialNetworkPK(int personId, int socialNetworkId) {
		
		this.personId = personId;
		this.socialNetworkId = socialNetworkId;
	}



	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public int getSocialNetworkId() {
		return socialNetworkId;
	}

	public void setSocialNetworkId(int socialNetworkId) {
		this.socialNetworkId = socialNetworkId;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + personId;
		result = prime * result + socialNetworkId;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonSocialNetworkPK other = (PersonSocialNetworkPK) obj;
		if (personId != other.personId)
			return false;
		if (socialNetworkId != other.socialNetworkId)
			return false;
		return true;
	}
	
	
}
