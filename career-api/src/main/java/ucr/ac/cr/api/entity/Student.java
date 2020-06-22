package ucr.ac.cr.api.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name="Student")
@NamedStoredProcedureQuery(name="Student.getStudentById", procedureName = "Get_Students_By_id", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Id", type = Integer.class)})

@NamedStoredProcedureQuery(name="Student.getAllStudent", resultClasses = {Student.class}, procedureName = "Get_Students")

@NamedStoredProcedureQuery(name="Student.updateStudent", procedureName = "Insert_Update_Student", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Person_id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Email", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Password", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Name", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Last_name", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Interests", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Profile_pic", type = Byte.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Status", type = boolean.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Distric_id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Canton_id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Province_id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Create_at", type = Date.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Updated_by", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Updated_at", type = Date.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Role", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Carne", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Action", type = String.class)
})

@NamedStoredProcedureQuery(name="Student.insertStudent", procedureName = "Insert_Update_Student", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Person_id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Email", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Password", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Name", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Last_name", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Interests", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Profile_pic", type = Byte.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Status", type = boolean.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Distric_id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Canton_id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Province_id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Create_at", type = Date.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Updated_by", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Updated_at", type = Date.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Role", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Carne", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Action", type = String.class)
})


public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int studentId;
    public boolean status;
    public String carne;
    public boolean isPresident;
    public int personId;
    public String email;
    public String password;
    public String name;
    public String lastName;
    public String interests;
    public boolean statusP;
    public int districId;
    public int cantonId;
    public int provinceId;
    public int createdBy;
    public Date createAt;
    public int updatedBy;
    public Date updatedAt;
    public String role;
    public String imgString;
    public byte[] profilePic;


    public Student() {
    }

    public Student(boolean status, String carne, boolean isPresident, int personId, String email, String password, String name, String lastName, String interests, boolean statusP, int districId, int cantonId, int provinceId, int createdBy, Date createAt, int updatedBy, Date updatedAt, String role, String imgString) {
        this.status = status;
        this.carne = carne;
        this.isPresident = isPresident;
        this.personId = personId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.interests = interests;
        this.statusP = statusP;
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

    public Student(boolean status, String carne, boolean isPresident, int personId, String email, String password, String name, String lastName, String interests, byte[] profilePic, boolean statusP, int districId, int cantonId, int provinceId, int createdBy, Date createAt, int updatedBy, Date updatedAt, String role, String imgString) {
        this.status = status;
        this.carne = carne;
        this.isPresident = isPresident;
        this.personId = personId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.interests = interests;
        this.profilePic = profilePic;
        this.statusP = statusP;
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

    public byte[] getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(byte[] profilePic) {
        this.profilePic = profilePic;
    }

    public boolean isStatusP() {
        return statusP;
    }

    public void setStatusP(boolean statusP) {
        this.statusP = statusP;
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
