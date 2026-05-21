package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * MarksheetDTO represents a student's marksheet entity in the system.
 * <p>
 * This class extends {@link BaseDTO} and contains information about a student's
 * roll number, name, marks in various subjects, and the associated student ID.
 * It is mapped to the "st_marksheet" table in the database.
 */
@Entity
@Table(name = "st_marksheet")
public class MarksheetDTO extends BaseDTO {

    /** Roll number of the student */
    @Column(name = "roll_no", length = 20)
    protected String rollNo = null;

    /** ID of the student associated with this marksheet */
    @Column(name = "student_id")
    protected Long studentId;

    /** Name of the student */
    @Column(name = "name", length = 50)
    protected String name = null;

    /** Marks obtained in Physics */
    @Column(name = "physics")
    protected Integer physics;

    /** Marks obtained in Chemistry */
    @Column(name = "chemistry")
    protected Integer chemistry;

    /** Marks obtained in Maths */
    @Column(name = "maths")
    protected Integer maths;

    // Getters and setters

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhysics() {
        return physics;
    }

    public void setPhysics(Integer physics) {
        this.physics = physics;
    }

    public Integer getChemistry() {
        return chemistry;
    }

    public void setChemistry(Integer chemistry) {
        this.chemistry = chemistry;
    }

    public Integer getMaths() {
        return maths;
    }

    public void setMaths(Integer maths) {
        this.maths = maths;
    }

    /**
     * Returns the unique key field for this DTO.
     *
     * @return "rollNo" as the unique key
     */
    @Override
    public String getUniqueKey() {
        return "rollNo";
    }

    /**
     * Returns the unique value for this DTO based on the unique key.
     *
     * @return roll number of the student
     */
    @Override
    public String getUniqueValue() {
        return rollNo;
    }

    /**
     * Returns a human-readable label for this DTO.
     *
     * @return "Roll No"
     */
    @Override
    public String getLabel() {
        return "Roll No";
    }

    /**
     * Returns the database table name associated with this DTO.
     *
     * @return "Marksheet"
     */
    @Override
    public String getTableName() {
        return "Marksheet";
    }

    /**
     * Returns a value representing this DTO for dropdowns or display.
     *
     * @return name of the student
     */
    @Override
    public String getValue() {
        return name;
    }
}