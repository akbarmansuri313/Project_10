package com.rays.form;

import java.util.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.TimeTableDTO;

/**
 * TimeTableForm is a form class used for capturing and transferring
 * timetable-related data from the presentation layer to the business layer.
 * <p>
 * This form extends BaseForm and includes validation constraints for
 * fields like course, subject, exam date, exam time, semester, and description.
 * It also provides a method to convert itself into a TimeTableDTO object
 * for persistence operations.
 */
public class TimeTableForm extends BaseForm {

    /** ID of the course (required, must be >= 1) */
    @NotNull(message = "Course is required")
    @Min(1)
    private Long courseId = 0L;

    /** Name of the course */
    private String courseName;

    /** ID of the subject (required, must be >= 1) */
    @NotNull(message = "Subject is required")
    @Min(1)
    private Long subjectId = 0L;

    /** Name of the subject */
    private String subjectName;

    /** Exam date (required) */
    @NotNull(message = "Exam Date is required")
    private Date examDate;

    /** Exam time (required) */
    @NotEmpty(message = "Exam Time is required")
    private String examTime;

    /** Semester of the exam (required) */
    @NotEmpty(message = "Semester is required")
    private String semester;

    /** Description of the exam (required) */
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

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Converts this form into a TimeTableDTO object for persistence.
     *
     * @return a populated TimeTableDTO instance containing the form data
     */
    @Override
    public BaseDTO getDto() {

        TimeTableDTO dto = initDTO(new TimeTableDTO());
        dto.setCourseId(courseId);
        dto.setCourseName(courseName);
        dto.setSubjectId(subjectId);
        dto.setSubjectName(subjectName);
        dto.setExamDate(examDate);
        dto.setExamTime(examTime);
        dto.setSemester(semester);
        dto.setDescription(description);

        return dto;
    }
}