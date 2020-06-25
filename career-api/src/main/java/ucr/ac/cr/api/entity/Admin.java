package ucr.ac.cr.api.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="Professor")

@NamedStoredProcedureQuery(name="Admin.getAdmin", procedureName = "Get_Admin")

@NamedStoredProcedureQuery(name="Admin.promoteProfessor", procedureName = "Promote_Professor", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Professor_id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Update_by", type = Integer.class)})

public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int personId;
    public String email;
    public String password;
    public String name;
    public String lastName;
    public String interests;
    public boolean status;
    public int districId;
    public int cantonId;
    public int provinceId;
    public int createdBy;
    public Date createAt;
    public int updatedBy;
    public Date updatedAt;
    public String role;
    public String imgString;
    public boolean isAdmin;

    public Admin() {
    }

    public Admin(String email, String password, String name, String lastName, String interests, boolean status, int districId, int cantonId, int provinceId, int createdBy, Date createAt, int updatedBy, Date updatedAt, String role, String imgString, boolean isAdmin) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.interests = interests;
        this.status = status;
        this.districId = districId;
        this.cantonId = cantonId;
        this.provinceId = provinceId;
        this.createdBy = createdBy;
        this.createAt = createAt;
        this.updatedBy = updatedBy;
        this.updatedAt = updatedAt;
        this.role = role;
        this.imgString = imgString;
        this.isAdmin = isAdmin;
    }


}
