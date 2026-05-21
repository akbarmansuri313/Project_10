package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * DepartmentDTO represents a department entity in the system.
 * <p>
 * This class extends {@link BaseDTO} and contains information about
 * a department, including its code, name, head, and status.
 * It is mapped to the "st_department" table in the database.
 */
@Entity
@Table(name = "st_department")
public class DepartmentDTO extends BaseDTO {

    /** Unique identifier for the department */
    @Column(name = "departmentId")
    private Long departmentId;

    /** Code of the department (unique) */
    @Column(name = "departmentCode")
    private String departmentCode;

    /** Name of the department */
    @Column(name = "departmentName")
    private String departmentName;

    /** Name of the head of the department */
    @Column(name = "headName")
    private String headName;

    /** Status of the department (e.g., Active/Inactive) */
    @Column(name = "departmentStatus")
    private String departmentStatus;

    // Getters and Setters

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getHeadName() {
        return headName;
    }

    public void setHeadName(String headName) {
        this.headName = headName;
    }

    public String getDepartmentStatus() {
        return departmentStatus;
    }

    public void setDepartmentStatus(String departmentStatus) {
        this.departmentStatus = departmentStatus;
    }

    /**
     * Returns the unique key field for this DTO.
     *
     * @return "departmentCode" as the unique key
     */
    @Override
    public String getUniqueKey() {
        return "departmentCode";
    }

    /**
     * Returns the unique value for this DTO based on the unique key.
     *
     * @return departmentCode of the department
     */
    @Override
    public String getUniqueValue() {
        return departmentCode;
    }

    /**
     * Returns a human-readable label for this DTO.
     *
     * @return "departmentCode"
     */
    @Override
    public String getLabel() {
        return "departmentCode";
    }

    /**
     * Returns the database table name associated with this DTO.
     *
     * @return "Department"
     */
    @Override
    public String getTableName() {
        return "Department";
    }
}