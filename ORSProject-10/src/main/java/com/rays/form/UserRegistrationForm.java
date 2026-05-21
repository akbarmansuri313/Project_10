package com.rays.form;

import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * UserRegistrationForm is a form class used to capture user registration details.
 * <p>
 * It includes fields for first name, last name, login ID, password, date of birth, gender, and phone number.
 * Field-level validation annotations ensure that required fields are provided and follow proper formats.
 */
public class UserRegistrationForm {

    /** First name of the user (required) */
    @NotEmpty(message = "First Name is required")
    private String firstName;

    /** Last name of the user (required) */
    @NotEmpty(message = "Last Name is required")
    private String lastName;

    /** Login ID (email) of the user (required) */
    @Email
    @NotEmpty(message = "Login Id is required")
    private String loginId;

    /** Password for the user account (required) */
    @NotEmpty(message = "Password is required")
    private String password;

    /** Date of birth of the user (required) */
    @NotNull(message = "Date of birth is required")
    private Date dob;

    /** Gender of the user (required) */
    @NotEmpty(message = "Gender is required")
    private String gender;

    /** Mobile phone number of the user (required, 10 digits) */
    @NotEmpty(message = "Mobile No is required")
    @Pattern(regexp = "(^$|[0-9]{10})")
    private String phone;

    // Getters and Setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}