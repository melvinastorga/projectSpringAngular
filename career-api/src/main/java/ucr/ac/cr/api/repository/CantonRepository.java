package ucr.ac.cr.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ucr.ac.cr.api.entity.Canton;
import ucr.ac.cr.api.entity.Course;

import java.util.List;


public interface CantonRepository extends JpaRepository<Canton, Integer> {

    @Query(value = "{ call [Get_Canton_By_Province](:Province_Id)}", nativeQuery = true)
    List<Canton> getCantonByProvince(@Param("Province_Id") Integer provinceId);
}
