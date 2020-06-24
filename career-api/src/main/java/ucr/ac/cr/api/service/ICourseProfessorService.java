package ucr.ac.cr.api.service;

import java.util.List;

import ucr.ac.cr.api.entity.CourseProfessor;

public interface ICourseProfessorService {

	List<CourseProfessor> getProfessorByCourse(int courseId);
	
}
