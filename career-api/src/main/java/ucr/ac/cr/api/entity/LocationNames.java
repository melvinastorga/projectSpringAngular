package ucr.ac.cr.api.entity;

import javax.persistence.*;

@Entity
@Table(name="District")

@NamedStoredProcedureQuery(name = "LocationNames.getLocationNames",procedureName = "Get_Names_District_Province_Canton", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Province_id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Canton_id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "District_id", type = Integer.class)})

public class LocationNames {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int districId;
    public int provinceId;
    public int cantonId;
    public String cantonName;
    public String provinceName;
    public String districtName;

    public LocationNames() {
    }

    public LocationNames(int districId, int provinceId, int cantonId, String cantonName, String provinceName, String districtName) {
        this.districId = districId;
        this.provinceId = provinceId;
        this.cantonId = cantonId;
        this.cantonName = cantonName;
        this.provinceName = provinceName;
        this.districtName = districtName;
    }

    public int getDistricId() {
        return districId;
    }

    public void setDistricId(int districId) {
        this.districId = districId;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getCantonId() {
        return cantonId;
    }

    public void setCantonId(int cantonId) {
        this.cantonId = cantonId;
    }

    public String getCantonName() {
        return cantonName;
    }

    public void setCantonName(String cantonName) {
        this.cantonName = cantonName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
}
