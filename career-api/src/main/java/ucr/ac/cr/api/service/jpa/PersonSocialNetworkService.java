package ucr.ac.cr.api.service.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucr.ac.cr.api.entity.PersonSocialNetwork;
import ucr.ac.cr.api.entity.PersonSocialNetworkPK;
import ucr.ac.cr.api.repository.CourseRepository;
import ucr.ac.cr.api.repository.PersonSocialNetworkRepository;
import ucr.ac.cr.api.service.ICourseService;
import ucr.ac.cr.api.service.IPersonSocialNetworkService;

@Service
@Transactional
public class PersonSocialNetworkService implements IPersonSocialNetworkService {

	@Autowired
	private PersonSocialNetworkRepository repoPersonSocialNetwork;

	@Override
	public List<PersonSocialNetwork> getPersonSocialNetworkByPersonId(int personId) {
		
		return repoPersonSocialNetwork.getPersonSocialNetworkByPersonId(personId);
	}

	@Override
	public void insertPersonSocialNetworkSP(PersonSocialNetworkPK personSocialNetworkPK,
			PersonSocialNetwork personSocialNetwork) {
		
		repoPersonSocialNetwork.insertPersonSocialNetworkSP(personSocialNetworkPK.getSocialNetworkId(), personSocialNetworkPK.getPersonId(), personSocialNetwork.getUrl());
	}

	@Override
	public void updatePersonSocialNetworkSP(PersonSocialNetworkPK personSocialNetworkPK,
			PersonSocialNetwork personSocialNetwork) {
		
		repoPersonSocialNetwork.updatePersonSocialNetworkSP(personSocialNetworkPK.getSocialNetworkId(), personSocialNetworkPK.getPersonId(), personSocialNetwork.getUrl());
		
	}

	@Override
	public void deletePersonSocialNetworkSP(int socialNetworkId, int personId) {
		
		repoPersonSocialNetwork.deletePersonSocialNetworkSP(socialNetworkId, personId);
	}
	
	
	
}
