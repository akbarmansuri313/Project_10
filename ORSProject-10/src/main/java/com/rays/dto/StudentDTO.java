package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * StudentDTO represents a student entity in the system.
 * <p>
 * This class extends {@link BaseDTO} and contains information such as enrollment number,
 * first name, last name, date of birth, contact details, and associated college information.
 * <p>
 * It is mapped to the "st_student" table in the database.
 */
@Entity
@Table(name = "st_student")
public class StudentDTO extends BaseDTO {

    /** Enrollment number of the student */
    @Column(name = "enrol_no", length = 20)
    private String enrolNo;

    /** First name of the student */
    @Column(name = "first_name", length = 50)
    private String firstName;

    /** Last name of the student */
    @Column(name = "last_name", length = 50)
    private String lastName;

    /** Date of birth of the student */
    @Column(name = "dob")
    private Date dob;

    /** Contact phone number of the student */
    @Column(name = "phone_no", length = 15)
    private String phoneNo;

    /** Email address of the student */
    @Column(name = "email", length = 50)
    private String email;

    /** ID of the college the student is enrolled in */
    @Column(name = "college_id")
    private Long collegeId;

    /** Name of the college the student is enrolled in */
    @Column(name = "college_name", length = 50)
    private String collegeName;

    // Getters and setters with field-level documentation

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
     * Returns the unique key field for this DTO.
     * 
     * @return "enrolNo" as the unique key
     */
    @Override
    public String getUniqueKey() {
        return "enrolNo";
    }

    /**
     * Returns the unique value for this DTO based on the unique key.
     * 
     * @return the enrollment number
     */
    @Override
    public String getUniqueValue() {
        return enrolNo;
    }

    /**
     * Returns a human-readable label for this DTO.
     * 
     * @return "Enroll No"
     */
    @Override
    public String getLabel() {
        return "Enroll No";
    }

    /**
     * Returns the database table name associated with this DTO.
     * 
     * @return "Student"
     */
    @Override
    public String getTableName() {
        return "Student";
    }

    /**
     * Returns the value to be used in dropdown lists.
     * 
     * @return the college name
     */
    @Override
    public String getValue() {
        return collegeName;
    }

}