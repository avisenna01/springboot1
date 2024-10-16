package first.maven.demomaven.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.Date;

@Entity
@Table(name = "customers")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    @NotEmpty
    private String email;
    private String phone;
    private String address;
    private String gender;
    private Date birthDate;
    private String firstName;
    private String lastName;
    private String pass;

    public Customers() {

    }

    public Customers(Integer customerId, String email, String phone,
                     String address, String gender, Date birthDate,
                     String firstName, String lastName, String pass) {
        this.customerId = customerId;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pass = pass;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPass() {
        return pass;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
