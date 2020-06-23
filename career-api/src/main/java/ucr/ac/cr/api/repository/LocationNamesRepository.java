package ucr.ac.cr.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ucr.ac.cr.api.entity.LocationNames;
import ucr.ac.cr.api.entity.Professor;

import java.util.List;


public interface LocationNamesRepository extends JpaRepository<LocationNames, Integer> {

    @Query(value= "{call [Get_Names_District_Province_Canton](:Province_id, :Canton_id, :District_id)}", nativeQuery = true)
    LocationNames getLocationNames(@Param("Province_id") Integer provinceId,
                                         @Param("Canton_id") Integer cantonId,
                                         @Param("District_id") Integer districtId);

}
