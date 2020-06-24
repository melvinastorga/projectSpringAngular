package ucr.ac.cr.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import ucr.ac.cr.api.entity.PersonSocialNetwork;

public interface PersonSocialNetworkRepository extends JpaRepository<PersonSocialNetwork, Integer>{

	@Query(value = "{ call SelectPersonSocialNetworkById(:Person_Id)}", nativeQuery = true)
	List<PersonSocialNetwork> getPersonSocialNetworkByPersonId(@Param("Person_Id") Integer personId);
	
	
	@Procedure(name = "PersonSocialNetwork.insertPersonSocialNetworkSP")
	void insertPersonSocialNetworkSP(@Param("Social_network_id") Integer socialNetworkId, @Param("Person_id") Integer personId, @Param("URL") String url);

	@Procedure(name = "PersonSocialNetwork.updatePersonSocialNetworkSP")
	void updatePersonSocialNetworkSP(@Param("Social_network_id") Integer socialNetworkId, @Param("Person_id") Integer personId, @Param("URL") String url);

	@Procedure(name = "PersonSocialNetwork.deletePersonSocialNetworkSP")
	void deletePersonSocialNetworkSP(@Param("Social_network_id") int socialNetworkId, @Param("Person_id") int personId);
	
	
}
