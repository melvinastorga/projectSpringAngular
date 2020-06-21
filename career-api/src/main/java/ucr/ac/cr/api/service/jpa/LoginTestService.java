package ucr.ac.cr.api.service.jpa;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucr.ac.cr.api.entity.LoginTest;
import ucr.ac.cr.api.repository.LoginTestRepository;
import ucr.ac.cr.api.repository.OfficeHoursRepository;
import ucr.ac.cr.api.service.ILoginTestService;
import ucr.ac.cr.api.service.IOfficeHoursService;

@Service
@Transactional
public class LoginTestService  implements ILoginTestService {

	@Autowired
	private LoginTestRepository repoLoginTest;
	
	@Override
	public LoginTest GetLogin(String email, String password) {
		
		return repoLoginTest.getLoginSP(email, password);
	}

}
