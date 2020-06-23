package ucr.ac.cr.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ucr.ac.cr.api.entity.Course;
import ucr.ac.cr.api.entity.Province;

import java.util.List;


public interface ProvinceRepository extends JpaRepository<Province, Integer> {

    @Query(value = "Get_Province", nativeQuery = true)
    List<Province> getProvince();
}
