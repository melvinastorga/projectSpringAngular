package ucr.ac.cr.api.service.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucr.ac.cr.api.entity.CourseProfessor;
import ucr.ac.cr.api.repository.CourseProfessorRepository;
import ucr.ac.cr.api.service.ICourseProfessorService;

@Service
@Transactional
public class CourseProfessorService implements ICourseProfessorService{

	@Autowired
	private CourseProfessorRepository repoCourseProfessor;

	@Override
	public List<CourseProfessor> getProfessorByCourse(int courseId) {
		
		return repoCourseProfessor.getProfessorByCourse(courseId);
	}
	
	
}
