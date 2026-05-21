package com.rays.form;

import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * MyProfileForm is a form class used to capture and validate
 * the profile information of a user. It includes personal details
 * such as first name, last name, login ID, gender, phone, and date of birth.
 * <p>
 * Validation constraints ensure that required fields are populated
 * and phone numbers follow a 10-digit format.
 */
public class MyProfileForm {

    /** User's first name (required) */
    @NotEmpty(message = "First Name is required")
    private String firstName;

    /** User's last name (required) */
    @NotEmpty(message = "Last Name is required")
    private String lastName;

    /** User's login ID (required) */
    @NotEmpty(message = "Login Id is required")
    private String loginId;

    /** User's gender (required) */
    @NotEmpty(message = "Gender is required")
    private String gender;

    /** User's phone number (required, 10-digit pattern) */
    @NotEmpty(message = "Mobile No is required")
    @Pattern(regexp = "(^$|[0-9]{10})")
    private String phone;

    /** User's date of birth (required) */
    @NotNull(message = "Date of birth is required")
    private Date dob;

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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}