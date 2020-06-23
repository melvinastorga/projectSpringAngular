package ucr.ac.cr.api.entity;

import javax.persistence.*;

@Entity
@Table(name="Province")

@NamedStoredProcedureQuery(name="Province.getProvince", procedureName = "Get_Province")

public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int provinceId;
    public String name;

    public Province() {
    }

    public Province(int provinceId, String name) {
        this.provinceId = provinceId;
        this.name = name;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
