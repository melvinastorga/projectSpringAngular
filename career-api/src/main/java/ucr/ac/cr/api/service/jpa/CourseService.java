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
	public List<Course> ListActiveCourses() {
		return repoCourse.getActiveCourses();
	}

	@Override
	public List<Course> ListOffCourses() {
		return repoCourse.getOffCourses();
	}

	@Override
	public Course GetCourseById(int courseId) {
		
		return repoCourse.getCourseById(courseId);
	}

	@Override
	public void insertCourseSP(Course course) {
		repoCourse.insertCourseSP(course.getCredits(), course.getCode(), course.getName(), course.getTerm(), course.getDescription());
	}

	@Override
	public void updateCourseSP(Course course) {
		repoCourse.updateCourseSP(course.getCourseId(), course.getCredits(), course.getCode(), course.getName(), course.getTerm(), course.getDescription());
		
	}

	@Override
	public void deleteCourseSP(Course course) {
		repoCourse.deleteteCourseSP(course.getCourseId());
		
	}

	@Override
	public void activeCourseSP(Course course) {
		repoCourse.activeCourseSP(course.getCourseId());
		
	}

	
	
}
