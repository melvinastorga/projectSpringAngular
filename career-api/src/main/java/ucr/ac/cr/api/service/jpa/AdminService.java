package ucr.ac.cr.api.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.api.entity.Admin;
import ucr.ac.cr.api.repository.AdminRepository;
import ucr.ac.cr.api.service.IAdmin;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdminService implements IAdmin {
    @Autowired
    AdminRepository adminRepository;

    @Override
    public void promoteProfessor(int professorId, int updatedBy) {
        adminRepository.promoteProfessor(professorId, updatedBy);
    }

    @Override
    public Admin getAdmin() {
        return adminRepository.getAdmin();
    }
}
