package ucr.ac.cr.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ucr.ac.cr.api.entity.Distric;

import java.util.List;


public interface DistricRepository extends JpaRepository<Distric, Integer> {

    @Query(value= "{ call [Get_District_By_Province_Canton](:Province_Id, :Canton_Id)}", nativeQuery = true)
    List<Distric> getDistrictByProvinceCanton(@Param("Province_Id") Integer provinceId,
                                              @Param("Canton_Id") Integer cantonId);
}
