package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * SubjectDTO represents a subject entity associated with a course.
 * <p>
 * This class extends {@link BaseDTO} and contains information such as course ID, course name,
 * subject name, and description.
 * <p>
 * It is mapped to the "st_subject" table in the database.
 */
@Entity
@Table(name = "st_subject")
public class SubjectDTO extends BaseDTO {
    
    /** Course ID associated with this subject */
    @Column(name = "course_id", length = 50)
    private long courseId;

    /** Course name associated with this subject */
    @Column(name = "course_name", length = 50)
    private String courseName;

    /** Name of the subject */
    @Column(name = "name", length = 50)
    private String name;

    /** Description or additional notes about the subject */
    @Column(name = "description", length = 50)
    private String description;

    // Getters and Setters with field-level documentation

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the unique key field for this DTO.
     * 
     * @return "name" as the unique key
     */
    @Override
    public String getUniqueKey() {
        return "name";
    }

    /**
     * Returns the unique value for this DTO based on the unique key.
     * 
     * @return the value of the subject name
     */
    @Override
    public String getUniqueValue() {
        return name;
    }

    /**
     * Returns a human-readable label for this DTO.
     * 
     * @return "Subject Name"
     */
    @Override
    public String getLabel() {
        return "Subject Name";
    }

    /**
     * Returns the database table name associated with this DTO.
     * 
     * @return "Subject"
     */
    @Override
    public String getTableName() {
        return "Subject";
    }

    /**
     * Returns the value to be used in dropdown lists.
     * 
     * @return the course name
     */
    @Override
    public String getValue() {
        return courseName;
    }
}