package ucr.ac.cr.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ucr.ac.cr.api.entity.Login;

public interface LoginTestRepository extends JpaRepository<Login, Integer> {

	//@Procedure(name = "LoginTest.getLoginTest")
	//LoginTest getLoginSP(@Param("Email") String email, @Param("Password") String password);

	@Query(value = "{ call SelectLogin(:Email, :Password)}", nativeQuery = true)
	Login getLoginSP(@Param("Email") String email, @Param("Password") String password);
	
}
