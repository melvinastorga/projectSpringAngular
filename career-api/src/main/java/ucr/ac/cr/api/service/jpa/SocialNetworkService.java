package ucr.ac.cr.api.service.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucr.ac.cr.api.entity.SocialNetwork;
import ucr.ac.cr.api.repository.CourseRepository;
import ucr.ac.cr.api.repository.SocialNetworkRepository;
import ucr.ac.cr.api.service.ICourseService;
import ucr.ac.cr.api.service.ISocialNetworkService;

@Service
@Transactional
public class SocialNetworkService implements ISocialNetworkService {

	
	@Autowired
	private SocialNetworkRepository repoSocialNetwork;

	@Override
	public List<SocialNetwork> getAllSocialNetworks() {
		
		return repoSocialNetwork.getAllSocialNetworks();
	}
	
}
