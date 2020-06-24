package ucr.ac.cr.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ucr.ac.cr.api.entity.SocialNetwork;

@Repository
public interface SocialNetworkRepository extends JpaRepository<SocialNetwork, Integer>{ 

	@Query(value = "SelectSocialNetwork", nativeQuery = true)
	List<SocialNetwork> getAllSocialNetworks();
	
}
