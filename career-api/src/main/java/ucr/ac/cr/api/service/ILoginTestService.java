package ucr.ac.cr.api.service;

import ucr.ac.cr.api.entity.Login;

public interface ILoginTestService {

	Login GetLogin(String email, String password);
	
}
