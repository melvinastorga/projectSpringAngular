package ucr.ac.cr.api.service.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucr.ac.cr.api.entity.Course;
import ucr.ac.cr.api.repository.CourseRepository;
import ucr.ac.cr.api.service.ICourseService;

@Service
@Transactional
public class CourseService implements ICourseService {

	@Autowired
	private CourseRepository repoCourse;
	
	@Override
	public List<Course> ListAll() {
		return repoCourse.findAll();
	}

	
	
}
