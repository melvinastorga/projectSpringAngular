package ucr.ac.cr.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ucr.ac.cr.api.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
