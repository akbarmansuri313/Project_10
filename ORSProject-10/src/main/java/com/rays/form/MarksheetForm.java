package com.rays.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.MarksheetDTO;

/**
 * MarksheetForm is a form class used to capture and validate
 * marks for a student in various subjects such as Physics, Chemistry, and Maths.
 * <p>
 * Validation constraints ensure that:
 * <ul>
 *   <li>Roll number is not empty</li>
 *   <li>Student ID is present and greater than 0</li>
 *   <li>Marks for each subject are between 0 and 99</li>
 * </ul>
 * This form is used to create or update MarksheetDTO objects.
 */
public class MarksheetForm extends BaseForm {

    /** Roll number of the student (required) */
    @NotEmpty(message = "Roll No is required")
    protected String rollNo = null;

    /** Student ID (required, min value 1) */
    @NotNull(message = "Student Name is required")
    @Min(1)
    protected Long studentId;

    /** Student name */
    protected String name = null;

    /** Physics marks (required, 0-99) */
    @NotNull(message = "Physics is required")
    @Max(99)
    @Min(0)
    protected Integer physics;

    /** Chemistry marks (required, 0-99) */
    @NotNull(message = "Chemistry is required")
    @Max(99)
    @Min(0)
    protected Integer chemistry;

    /** Maths marks (required, 0-99) */
    @NotNull(message = "Maths is required")
    @Max(99)
    @Min(0)
    protected Integer maths;

    // Getters and Setters
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
     * Converts this form into a MarksheetDTO object.
     * 
     * @return MarksheetDTO populated with values from this form
     */
    @Override
    public BaseDTO getDto() {
        MarksheetDTO dto = initDTO(new MarksheetDTO());
        dto.setRollNo(rollNo);
        dto.setName(name);
        dto.setStudentId(studentId);
        dto.setPhysics(physics);
        dto.setChemistry(chemistry);
        dto.setMaths(maths);

        return dto;
    }
}