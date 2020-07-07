package examen.api.service;

import java.util.List;

import examen.api.entity.Major;

public interface IMajorService {

	List<Major> get_majors();
	Major get_major(int major_id);
	void delete_major(int major_id);
	void insert_major(Major major);
	void update_major(Major major);
}
