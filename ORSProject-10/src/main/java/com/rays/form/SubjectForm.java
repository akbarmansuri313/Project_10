package com.rays.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.SubjectDTO;

/**
 * SubjectForm is a form class used for capturing and transferring
 * subject-related data from the presentation layer to the business layer.
 * <p>
 * This form extends BaseForm and includes validation constraints for
 * course, subject name, and description fields. It provides a method
 * to convert itself into a SubjectDTO object for persistence.
 */
public class SubjectForm extends BaseForm {

    /** ID of the course associated with this subject (required, must be >= 1) */
    @NotNull(message = "Course is required")
    @Min(1)
    private Long courseId = 0L;

    /** Name of the course associated with this subject */
    @NotEmpty(message = "subject Name is Required")
    private String courseName;

    /** Name of the subject (required) */
    @NotEmpty(message = "Name is required")
    private String name;

    /** Description of the subject (required) */
    @NotEmpty(message = "Description is required")
    private String description;

    // Getters and Setters

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
     * Converts this form into a SubjectDTO object for persistence.
     *
     * @return a populated SubjectDTO instance containing the form data
     */
    @Override
    public BaseDTO getDto() {

        SubjectDTO dto = initDTO(new SubjectDTO());

        dto.setCourseId(courseId);
        dto.setCourseName(courseName);
        dto.setName(name);
        dto.setDescription(description);

        return dto;
    }
}