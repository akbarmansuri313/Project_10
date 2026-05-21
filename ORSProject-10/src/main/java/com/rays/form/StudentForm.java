package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.StudentDTO;

/**
 * StudentForm is a form class used for capturing and transferring
 * student-related data from the presentation layer to the business layer.
 * <p>
 * This form extends BaseForm and includes validation constraints for
 * enrollment number, personal details, contact info, and college information.
 * It provides a method to convert itself into a StudentDTO object for persistence.
 */
public class StudentForm extends BaseForm {

    /** Enrollment number of the student (required) */
    @NotEmpty(message = "Enroll No is required")
    private String enrolNo;

    /** First name of the student (required) */
    @NotEmpty(message = "First Name is required")
    private String firstName;

    /** Last name of the student (required) */
    @NotEmpty(message = "Last Name is required")
    private String lastName;

    /** Date of birth of the student (required) */
    @NotNull(message = "Date of birth is required")
    private Date dob;

    /** Phone number of the student (required, 10 digits) */
    @NotNull(message = "Phone No is required")
    @Pattern(regexp = "(^$|[0-9]{10})")
    private String phoneNo;

    /** Email of the student (required, valid email format) */
    @NotEmpty(message = "Email ID is required")
    @Email
    private String email;

    /** College ID to which the student belongs (required, must be >= 1) */
    @NotNull(message = "College Name is required")
    @Min(1)
    private Long collegeId;

    /** College name (optional, for display purposes) */
    private String collegeName;

    // Getters and Setters

    public String getEnrolNo() {
        return enrolNo;
    }

    public void setEnrolNo(String enrolNo) {
        this.enrolNo = enrolNo;
    }

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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    /**
     * Converts this form into a StudentDTO object for persistence.
     *
     * @return a populated StudentDTO instance containing the form data
     */
    @Override
    public BaseDTO getDto() {

        StudentDTO dto = initDTO(new StudentDTO());

        dto.setEnrolNo(enrolNo);
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setDob(dob);
        dto.setPhoneNo(phoneNo);
        dto.setEmail(email);
        dto.setCollegeId(collegeId);
        dto.setCollegeName(collegeName);

        return dto;
    }
}