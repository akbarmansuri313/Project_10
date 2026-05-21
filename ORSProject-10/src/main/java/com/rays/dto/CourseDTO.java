package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * CourseDTO represents a course entity in the system.
 * <p>
 * This class extends {@link BaseDTO} and contains information about
 * a course, including its name, duration, and description.
 * It is mapped to the "st_course" table in the database.
 */
@Entity
@Table(name = "st_course")
public class CourseDTO extends BaseDTO {

    /** Name of the course (unique) */
    @Column(name = "name", length = 50)
    private String name;

    /** Duration of the course (e.g., 3 years, 6 months) */
    @Column(name = "duration", length = 50)
    private String duration;

    /** Description of the course */
    @Column(name = "description", length = 50)
    private String description;

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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
     * @return name of the course
     */
    @Override
    public String getUniqueValue() {
        return name;
    }

    /**
     * Returns a human-readable label for this DTO.
     *
     * @return "Course Name"
     */
    @Override
    public String getLabel() {
        return "Course Name";
    }

    /**
     * Returns the database table name associated with this DTO.
     *
     * @return "Course"
     */
    @Override
    public String getTableName() {
        return "Course";
    }

    /**
     * Returns the display value of this DTO for dropdowns or lists.
     *
     * @return name of the course
     */
    @Override
    public String getValue() {
        return name;
    }
}