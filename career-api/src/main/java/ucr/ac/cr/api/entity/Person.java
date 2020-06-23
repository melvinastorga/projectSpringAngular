package ucr.ac.cr.api.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Person")

@NamedStoredProcedureQuery(name="Person.authenticateUser", procedureName = "SelectLogin", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Email", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Password", type = String.class)})

@NamedStoredProcedureQuery(name="Person.desactivatePerson", procedureName = "Desactivate_Person_Account", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Person_id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Update_by", type = Integer.class)})

@NamedStoredProcedureQuery(name="Person.activatePerson", procedureName = "Reactivate_Person_Account", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Person_id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Update_by", type = Integer.class)})

public class Person {

    public int PersonId;
    public String Email;
    public String Password;
    public String Name;
    public String LastName;
    public String Interests;
    public byte[] ProfilePic;
    public boolean Status;
    public int DistricId;
    public int CantonId;
    public int ProvinceId;
    public int CreatedBy;
    public Date CreateAt;
    public int UpdatedBy;
    public Date UpdatedAt;
    public String Role;
    public String ImgString;

    public Person(int personId, String email, String password, String name, String last_name, String interests, byte[] profile_pic, boolean status, int districId, int cantonId, int provinceId, int createdBy, Date createAt, int updatedBy, Date updatedAt, String role, String imgString) {
        PersonId = personId;
        Email = email;
        Password = password;
        Name = name;
        LastName = last_name;
        Interests = interests;
        ProfilePic = profile_pic;
        Status = status;
        DistricId = districId;
        CantonId = cantonId;
        ProvinceId = provinceId;
        CreatedBy = createdBy;
        CreateAt = createAt;
        UpdatedBy = updatedBy;
        UpdatedAt = updatedAt;
        Role = role;
        ImgString = imgString;
    }

    public Person(int personId, boolean status, String role) {
        this.PersonId = personId;
        this.Status = status;
        this.Role = role;
    }


    public Person() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getPersonId() {
        return PersonId;
    }

    public void setPersonId(int personId) {
        PersonId = personId;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getInterests() {
        return Interests;
    }

    public void setInterests(String interests) {
        Interests = interests;
    }

    public byte[] getProfilePic() {
        return ProfilePic;
    }

    public void setProfilePic(byte[] profilePic) {
        ProfilePic = profilePic;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public int getDistricId() {
        return DistricId;
    }

    public void setDistricId(int districId) {
        DistricId = districId;
    }

    public int getCantonId() {
        return CantonId;
    }

    public void setCantonId(int cantonId) {
        CantonId = cantonId;
    }

    public int getProvinceId() {
        return ProvinceId;
    }

    public void setProvinceId(int provinceId) {
        ProvinceId = provinceId;
    }

    public int getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(int createdBy) {
        CreatedBy = createdBy;
    }

    public Date getCreateAt() {
        return CreateAt;
    }

    public void setCreateAt(Date createAt) {
        CreateAt = createAt;
    }

    public int getUpdatedBy() {
        return UpdatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        UpdatedBy = updatedBy;
    }

    public Date getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        UpdatedAt = updatedAt;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getImgString() {
        return ImgString;
    }

    public void setImgString(String imgString) {
        ImgString = imgString;
    }
}
