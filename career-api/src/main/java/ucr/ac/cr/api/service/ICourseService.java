package ucr.ac.cr.api.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import ucr.ac.cr.api.entity.Course;

public interface ICourseService {
	List<Course> ListActiveCourses();
	List<Course> ListOffCourses();
	Course GetCourseById(int courseId);
	void insertCourseSP(Course course);
	void updateCourseSP(Course course);
	void deleteCourseSP(Course course);
	void activeCourseSP(Course course);
}

