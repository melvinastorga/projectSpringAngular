package ucr.ac.cr.api.service;

import java.util.List;

import ucr.ac.cr.api.entity.Course;
import ucr.ac.cr.api.entity.OfficeHours;

public interface IOfficeHoursService {
	List<OfficeHours> ListAllOfficeHours();
	OfficeHours GetOfficeHoursById(int officeHoursId);
	List<OfficeHours> GetOfficeHoursByCourse(int professorCourseId);
	void insertOfficeHours(OfficeHours officeHours);
	void updateOfficeHours(OfficeHours officeHours);
	void deleteOfficeHours(int officeHoursId);
}
