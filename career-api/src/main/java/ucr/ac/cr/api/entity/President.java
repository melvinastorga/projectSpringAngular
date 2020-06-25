package ucr.ac.cr.api.entity;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="Student")
@NamedStoredProcedureQuery(name="President.getPresident", procedureName = "Get_President")

@NamedStoredProcedureQuery(name="President.promoteStudent", procedureName = "Promote_Student", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Student_id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Update_by", type = Integer.class)})

public class President {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public int studentId;
    public boolean status;
    public boolean studentStatus;
    public String carne;
    public boolean isPresident;
    public int personId;
    public String email;
    public String password;
    public String name;
    public String lastName;
    public String interests;
    public int districId;
    public int cantonId;
    public int provinceId;
    public int createdBy;
    public Date createAt;
    public int updatedBy;
    public Date updatedAt;
    public String role;
    public String imgString;

    public President() {
    }

    public President(int studentId, boolean studentStatus, String carne, boolean isPresident, int personId, String email, String password, String name, String lastName, String interests, int districId, int cantonId, int provinceId, int createdBy, Date createAt, int updatedBy, Date updatedAt, String role, String imgString) {
        this.studentId = studentId;
        this.studentStatus = studentStatus;
        this.carne = carne;
        this.isPresident = isPresident;
        this.personId = personId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.interests = interests;
        this.districId = districId;
        this.cantonId = cantonId;
        this.provinceId = provinceId;
        this.createdBy = createdBy;
        this.createAt = createAt;
        this.updatedBy = updatedBy;
        this.updatedAt = updatedAt;
        this.role = role;
        this.imgString = imgString;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(boolean studentStatus) {
        this.studentStatus = studentStatus;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public boolean isPresident() {
        return isPresident;
    }

    public void setPresident(boolean president) {
        isPresident = president;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public int getDistricId() {
        return districId;
    }

    public void setDistricId(int districId) {
        this.districId = districId;
    }

    public int getCantonId() {
        return cantonId;
    }

    public void setCantonId(int cantonId) {
        this.cantonId = cantonId;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getImgString() {
        return imgString;
    }

    public void setImgString(String imgString) {
        this.imgString = imgString;
    }
}
