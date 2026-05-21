package com.rays.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.DepartmentDTO;

/**
 * Form class for capturing Department details.
 * Provides validation and DTO conversion.
 */
public class DepartmentForm extends BaseForm {

    @NotNull(message = "Department Id is required")
    @Min(value = 1, message = "Department Id must be greater than 0")
    private long departmentId;

    @NotEmpty(message = "Department Code is required")
    private String departmentCode;

    @NotEmpty(message = "Department Name is required")
    private String departmentName;

    @NotEmpty(message = "Head Name is required")
    private String headName;

    @NotEmpty(message = "Department Status is required")
    private String departmentStatus;

    // Getters and Setters
    public long getDepartmentId() { return departmentId; }
    public void setDepartmentId(long departmentId) { this.departmentId = departmentId; }

    public String getDepartmentCode() { return departmentCode; }
    public void setDepartmentCode(String departmentCode) { this.departmentCode = departmentCode; }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }

    public String getHeadName() { return headName; }
    public void setHeadName(String headName) { this.headName = headName; }

    public String getDepartmentStatus() { return departmentStatus; }
    public void setDepartmentStatus(String departmentStatus) { this.departmentStatus = departmentStatus; }

    @Override
    public BaseDTO getDto() {
        DepartmentDTO dto = initDTO(new DepartmentDTO());
        dto.setDepartmentId(departmentId);
        dto.setDepartmentCode(departmentCode);
        dto.setDepartmentName(departmentName);
        dto.setHeadName(headName);
        dto.setDepartmentStatus(departmentStatus);
        return dto;
    }
}