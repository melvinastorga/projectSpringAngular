package ucr.ac.cr.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Social_Network")
@NamedStoredProcedureQuery(name = "SocialNetwork.getAllSocialNetworks", procedureName = "SelectSocialNetwork")
public class SocialNetwork {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int socialNetworkId;
	private String name;
	private byte[] SocialNetworkPic;
	private String socialNetworkImagesString;
	
	public SocialNetwork() {
	
	}

	public SocialNetwork(int socialNetworkId, String name, byte[] socialNetworkPic, String socialNetworkImagesString) {
		
		this.socialNetworkId = socialNetworkId;
		this.name = name;
		SocialNetworkPic = socialNetworkPic;
		this.socialNetworkImagesString = socialNetworkImagesString;
	}

	public int getSocialNetworkId() {
		return socialNetworkId;
	}

	public void setSocialNetworkId(int socialNetworkId) {
		this.socialNetworkId = socialNetworkId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getSocialNetworkPic() {
		return SocialNetworkPic;
	}

	public void setSocialNetworkPic(byte[] socialNetworkPic) {
		SocialNetworkPic = socialNetworkPic;
	}

	public String getSocialNetworkImagesString() {
		return socialNetworkImagesString;
	}

	public void setSocialNetworkImagesString(String socialNetworkImagesString) {
		this.socialNetworkImagesString = socialNetworkImagesString;
	}
	
	
}
