package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * FacultyDTO represents a faculty member entity in the system.
 * <p>
 * This class extends {@link BaseDTO} and contains information about
 * a faculty member, including personal details, contact information,
 * qualifications, and the courses and subjects they teach.
 * It is mapped to the "st_faculty" table in the database.
 */
@Entity
@Table(name = "st_faculty")
public class FacultyDTO extends BaseDTO {

    /** First name of the faculty member */
    @Column(name = "first_name", length = 50)
    private String firstName;

    /** Last name of the faculty member */
    @Column(name = "last_name", length = 50)
    private String lastName;

    /** Date of birth of the faculty member */
    @Column(name = "dob")
    private Date dob;

    /** Gender of the faculty member */
    @Column(name = "gender", length = 10)
    private String gender;

    /** Contact phone number */
    @Column(name = "phone_no", length = 15)
    private String phoneNo;

    /** Email address (unique) */
    @Column(name = "email", length = 50)
    private String email;

    /** Qualification of the faculty member */
    @Column(name = "qualification", length = 15)
    private String qualification;

    /** College ID where the faculty is associated */
    @Column(name = "college_id", length = 50)
    private long collegeId;

    /** College name */
    @Column(name = "college_name", length = 50)
    private String collegeName;

    /** Course ID assigned to the faculty */
    @Column(name = "course_id", length = 50)
    private long courseId;

    /** Course name assigned to the faculty */
    @Column(name = "course_name", length = 50)
    private String courseName;

    /** Subject ID assigned to the faculty */
    @Column(name = "subject_id", length = 50)
    private long subjectId;

    /** Subject name assigned to the faculty */
    @Column(name = "subject_name", length = 50)
    private String subjectName;

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

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(long collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * Returns the unique key field for this DTO.
     *
     * @return "email" as the unique key
     */
    @Override
    public String getUniqueKey() {
        return "email";
    }

    /**
     * Returns the unique value for this DTO based on the unique key.
     *
     * @return email of the faculty member
     */
    @Override
    public String getUniqueValue() {
        return email;
    }

    /**
     * Returns a human-readable label for this DTO.
     *
     * @return "Email"
     */
    @Override
    public String getLabel() {
        return "Email";
    }

    /**
     * Returns the database table name associated with this DTO.
     *
     * @return "Faculty"
     */
    @Override
    public String getTableName() {
        return "Faculty";
    }
}