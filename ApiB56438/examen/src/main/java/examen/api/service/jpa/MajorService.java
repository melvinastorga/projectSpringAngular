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
	public List<Major> getAllMajors() {
		
		return repoMajor.getAllMajors();
	}

	@Override
	public Major GetMajorById(int majorId) {
		
		return repoMajor.getMajorById(majorId);
	}

	@Override
	public void deleteMajor(int majorId) {
		
		repoMajor.deleteMajor(majorId);
	}

	@Override
	public void insertMajor(Major major) {
		repoMajor.insertMajor(major.getMajorName(), major.getMajorDescription(), major.getSemesters());
		
	}

	@Override
	public void updateMajor(Major major) {
		repoMajor.updateMajor(major.getMajorId(), major.getMajorName(), major.getMajorDescription(), major.getSemesters());
		
	}
	
	//@Override
	//public void insertMajor(Major major) {

		//repoMajor.insertMajor(major.getMajorId(), major.getMajorName(), major.getSemesters(), "insert");
	//}

	//@Override
	//public void updateMajor(Major major) {

		//repoMajor.updateMajor(major.getMajorId(), major.getMajorName(), major.getSemesters(), "update");
	//}

}
