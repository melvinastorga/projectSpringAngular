package ucr.ac.cr.api.service;

import ucr.ac.cr.api.entity.Course;
import ucr.ac.cr.api.entity.ProfessorCourse;

public interface IProfessorCourseService {

	ProfessorCourse GetCourseByProfessor(int professorId);
	
}
