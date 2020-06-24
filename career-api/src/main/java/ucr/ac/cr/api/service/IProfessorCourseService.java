package ucr.ac.cr.api.service;

import java.util.List;

import ucr.ac.cr.api.entity.Course;
import ucr.ac.cr.api.entity.ProfessorCourse;

public interface IProfessorCourseService {

	List<ProfessorCourse> GetCourseByProfessor(int professorId);
	void insertUpdateProfessorCourseSP(ProfessorCourse professorCourse);
	void deleteProfessorCourseSP(ProfessorCourse professorCourse);
}
