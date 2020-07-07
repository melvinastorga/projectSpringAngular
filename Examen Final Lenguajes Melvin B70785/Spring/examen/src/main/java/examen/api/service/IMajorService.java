package examen.api.service;

import java.util.List;

import examen.api.entity.Major;

public interface IMajorService {

	List<Major> getAllMajors();
	Major getLastMajor();
	Major GetMajorById(int majorId);
	void deleteMajor(int majorId);
	void insertMajor(Major major);
	void updateMajor(Major major);
}
