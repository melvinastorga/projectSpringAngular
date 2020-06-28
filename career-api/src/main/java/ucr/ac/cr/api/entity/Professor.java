package ucr.ac.cr.api.entity;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name ="Professor")

@NamedStoredProcedureQuery(name="Professor.getProfessorById", procedureName = "Get_Professor_By_Id", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Id", type = Integer.class)})

@NamedStoredProcedureQuery(name="Professor.getAllProfessor", procedureName = "Get_Professors")

@NamedStoredProcedureQuery(name="Professor.getProfessorsOff", procedureName = "Get_Professors_Off")

@NamedStoredProcedureQuery(name="Professor.updateProfessor", procedureName = "Insert_Update_Professor", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Person_id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Email", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Password", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Name", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Last_name", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Interests", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Profile_pic", type = byte[].class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Status", type = boolean.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Distric_id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Canton_id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Province_id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Created_by", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Create_at", type = Date.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Updated_by", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Updated_at", type = Date.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Role", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Especiality", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Action", type = String.class)
})

@NamedStoredProcedureQuery(name="Professor.insertProfessor", procedureName = "Insert_Update_Professor", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Person_id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Email", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Password", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Name", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Last_name", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Interests", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Profile_pic", type = byte[].class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Status", type = boolean.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Distric_id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Canton_id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Province_id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Created_by", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Create_at", type = Date.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Updated_by", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Updated_at", type = Date.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Role", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Especiality", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Action", type = String.class)
})



public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int professorId;
    public String especiality;
    public boolean isAdmin;
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

    @Column(name="Profile_pic")
    public byte[] profilePic;


    public Professor() {
    }

    public Professor(int professorId, String especiality, boolean isAdmin, int personId, String email, String password, String name, String lastName, String interests, byte[] profilePic, boolean status, int districId, int cantonId, int provinceId, String role, String imgString) {
        this.professorId = professorId;
        this.especiality = especiality;
        this.isAdmin = isAdmin;
        this.personId = personId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.interests = interests;
        this.profilePic = profilePic;
        this.status = status;
        this.districId = districId;
        this.cantonId = cantonId;
        this.provinceId = provinceId;
        this.role = role;
        this.imgString = imgString;
    }

    public Professor(int professorId, String especiality, boolean isAdmin, int personId, String email, String password, String name, String lastName, String interests, byte[] profilePic, boolean status, int districId, int cantonId, int provinceId, int createdBy, Date createAt, int updatedBy, Date updatedAt, String role, String imgString) {
        this.professorId = professorId;
        this.especiality = especiality;
        this.isAdmin = isAdmin;
        this.personId = personId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.interests = interests;
        this.profilePic = profilePic;
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
    }



    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public String getEspeciality() {
        return especiality;
    }

    public void setEspeciality(String especiality) {
        this.especiality = especiality;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
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

    public boolean isStatus() { return status; }

    public void setStatus(boolean status) { this.status = status; }

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
