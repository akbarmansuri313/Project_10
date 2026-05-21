package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * TimeTableDTO represents a timetable or exam schedule entry for a course and subject.
 * <p>
 * This class extends {@link BaseDTO} and contains information such as course ID, course name,
 * subject ID, subject name, exam date, exam time, semester, and a description.
 * <p>
 * It is mapped to the "st_timetable" table in the database.
 */
@Entity
@Table(name = "st_timetable")
public class TimeTableDTO extends BaseDTO {

    /** Course ID associated with the timetable entry */
    @Column(name = "course_id", length = 50)
    private long courseId;

    /** Course name associated with the timetable entry */
    @Column(name = "course_name", length = 50)
    private String courseName;

    /** Subject ID associated with the timetable entry */
    @Column(name = "subject_id", length = 50)
    private long subjectId;

    /** Subject name associated with the timetable entry */
    @Column(name = "subject_name", length = 50)
    private String subjectName;

    /** Date of the exam */
    @Column(name = "exam_date")
    private Date examDate;

    /** Time of the exam */
    @Column(name = "exam_time", length = 50)
    private String examTime;

    /** Semester for which this timetable entry is applicable */
    @Column(name = "semester", length = 30)
    private String semester;

    /** Additional description or notes */
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
     * Returns the unique key field for this DTO.
     * 
     * @return the unique key, "courseName"
     */
    @Override
    public String getUniqueKey() {
        return "courseName";
    }

    /**
     * Returns the unique value of the DTO based on the unique key.
     * 
     * @return the value of courseName
     */
    @Override
    public String getUniqueValue() {
        return courseName;
    }

    /**
     * Returns a human-readable label for this DTO.
     * 
     * @return null, no specific label defined
     */
    @Override
    public String getLabel() {
        return null;
    }

    /**
     * Returns the table name associated with this DTO.
     * 
     * @return "TimeTable"
     */
    @Override
    public String getTableName() {
        return "TimeTable";
    }
}