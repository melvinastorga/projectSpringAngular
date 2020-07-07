package examen.api.service.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import examen.api.entity.Major;
import examen.api.repository.MajorRepository;

@Service
@Transactional
public class MajorService  {

	@Autowired
	private MajorRepository repoMajor;
	

	public List<Major> getMajors() {
		
		return repoMajor.getAllMajors();
	}

	public Major getMajorById(int majorId) {

		return repoMajor.getMajorById(majorId);
	}

	public void deleteMajor(int majorId) {

		repoMajor.deleteMajor(majorId);
	}

	public void insertMajor(Major major) {

		repoMajor.insertMajor(major.getMajorId(), major.getMajorName(), major.getSemesterQuantity(), "insert");
	}


	public void updateMajor(Major major) {

		repoMajor.updateMajor(major.getMajorId(), major.getMajorName(), major.getSemesterQuantity(), "update");
	}

}
