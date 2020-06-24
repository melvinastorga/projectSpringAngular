package ucr.ac.cr.api.service.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucr.ac.cr.api.entity.ProfessorCourse;
import ucr.ac.cr.api.repository.CourseRepository;
import ucr.ac.cr.api.repository.ProfessorCourseRepository;
import ucr.ac.cr.api.service.ICourseService;
import ucr.ac.cr.api.service.IProfessorCourseService;

@Service
@Transactional
public class ProfessorCourseService  implements IProfessorCourseService{

	@Autowired
	private ProfessorCourseRepository repoProfessorCourseModel;
	
	@Override
	public List<ProfessorCourse> GetCourseByProfessor(int professorId) {
		
		return repoProfessorCourseModel.getCourseByProfessor(professorId);
	}

	@Override
	public void insertUpdateProfessorCourseSP(ProfessorCourse professorCourse) {
		repoProfessorCourseModel.insertUpdateProfessorCourseSP(professorCourse.getProfessorId(), professorCourse.getCourseId());
		
	}

	@Override
	public void deleteProfessorCourseSP(ProfessorCourse professorCourse) {
		repoProfessorCourseModel.deleteProfessorCourseSP(professorCourse.getProfessorCourseId());
	}

}
