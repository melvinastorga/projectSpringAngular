package ucr.ac.cr.api.entity;

import javax.persistence.*;

@Entity
@Table(name="Distric")

@NamedStoredProcedureQuery(name="District.getDistrictByProvinceCanton", procedureName = "Get_District_By_Province_Canton", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Province_Id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Canton_Id", type = Integer.class)})

public class Distric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int districId;
    public int provinceId;
    public int cantonId;
    public String name;

    public Distric() {
    }

    public Distric(int provinceId, int cantonId, int districId, String name) {
        this.provinceId = provinceId;
        this.cantonId = cantonId;
        this.districId = districId;
        this.name = name;
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

    public int getDistricId() {
        return districId;
    }

    public void setDistricId(int districId) {
        this.districId = districId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
