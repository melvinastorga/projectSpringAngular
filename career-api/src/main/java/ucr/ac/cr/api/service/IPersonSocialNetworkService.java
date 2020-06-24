package ucr.ac.cr.api.service;

import java.util.List;

import ucr.ac.cr.api.entity.Course;
import ucr.ac.cr.api.entity.PersonSocialNetwork;
import ucr.ac.cr.api.entity.PersonSocialNetworkPK;

public interface IPersonSocialNetworkService {

	List<PersonSocialNetwork> getPersonSocialNetworkByPersonId(int personId);
	void insertPersonSocialNetworkSP(PersonSocialNetworkPK personSocialNetworkPK, PersonSocialNetwork personSocialNetwork);
	void updatePersonSocialNetworkSP(PersonSocialNetworkPK personSocialNetworkPK, PersonSocialNetwork personSocialNetwork);
	void deletePersonSocialNetworkSP(int socialNetworkId, int personId);
	
}
