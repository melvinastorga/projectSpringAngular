package ucr.ac.cr.api.service.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucr.ac.cr.api.entity.Course;
import ucr.ac.cr.api.entity.OfficeHours;
import ucr.ac.cr.api.repository.CourseRepository;
import ucr.ac.cr.api.repository.OfficeHoursRepository;
import ucr.ac.cr.api.service.ICourseService;
import ucr.ac.cr.api.service.IOfficeHoursService;


@Service
@Transactional
public class OfficeHoursService implements IOfficeHoursService {

	@Autowired
	private OfficeHoursRepository repoOfficeHours;
	
	@Override
	public List<OfficeHours> ListAllOfficeHours() {
		
		return repoOfficeHours.getAllOfficeHours();
	}

	@Override
	public OfficeHours GetOfficeHoursById(int officeHoursId) {
		
		return repoOfficeHours.getOfficeHoursById(officeHoursId);
	}

	@Override
	public List<OfficeHours> GetOfficeHoursByCourse(int professorCourseId) {
		
		return repoOfficeHours.getOfficeHoursByCourse(professorCourseId);
	}

	@Override
	public void insertOfficeHours(OfficeHours officeHours) {
		repoOfficeHours.insertOfficeHoursSP(officeHours.getStartHour(), officeHours.getEndHour(), officeHours.getDay(), officeHours.getProfessorCourseId());	
	}

	@Override
	public void updateOfficeHours(OfficeHours officeHours) {
		repoOfficeHours.updateOfficeHoursSP(officeHours.getOfficeHoursId(),officeHours.getStartHour(), officeHours.getEndHour(), officeHours.getDay(), officeHours.getProfessorCourseId());	
	}

	@Override
	public void deleteOfficeHours(int officeHoursId) {
		repoOfficeHours.deleteOfficeHoursSP(officeHoursId);
	}

}

