package ucr.ac.cr.api.service;

import ucr.ac.cr.api.entity.Course;
import ucr.ac.cr.api.entity.LoginTest;

public interface ILoginTestService {

	LoginTest GetLogin(String email, String password);
	
}
