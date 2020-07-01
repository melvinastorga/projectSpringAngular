package examen.api.service.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import examen.api.entity.Major;
import examen.api.repository.MajorRepository;
import examen.api.service.IMajorService;

@Service
@Transactional
public class MajorService implements IMajorService {

	@Autowired
	private MajorRepository repoMajor;
	


	@Override
	public Major get_major(int major_id) {
		
		return repoMajor.get_major(major_id);
	}

	@Override
	public void delete_major(int major_id) {
		
		repoMajor.delete_major(major_id);
	}



	@Override
	public List<Major> get_majors() {
		// TODO Auto-generated method stub
		return repoMajor.get_majors();
	}
	
	@Override
   public void insert_major(Major major) {

     repoMajor.insert_major(major.getMajor_id(), major.getMajor(), major.getSemesters(), "insert");
     
	}

	@Override
	public void update_major(Major major) {

 
		repoMajor.update_major(major.getMajor_id(), major.getMajor(), major.getSemesters(), "update");
}

}
