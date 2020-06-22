package ucr.ac.cr.api.entity;

import javax.persistence.*;

@Entity
@Table(name="Canton")

@NamedStoredProcedureQuery(name="Canton.getCantonByProvince", procedureName = "Get_Canton_By_Province", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Province_Id", type = Integer.class)})

public class Canton {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int cantonId;
    public int provinceId;
    public String name;

    public Canton() {
    }

    public Canton(int provinceId, int cantonId, String name) {
        this.provinceId = provinceId;
        this.cantonId = cantonId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
