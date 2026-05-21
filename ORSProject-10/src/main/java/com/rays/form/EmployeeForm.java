package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.EmployeeDTO;

public class EmployeeForm extends BaseForm {

	@NotEmpty(message = "employeeCode is Required")
	private String employeeCode;

	@NotEmpty(message = "employeeCode is Required")
	private String employeeName;

	@NotEmpty(message = "employeeCode is Required")
	private String designation;

	@NotEmpty(message = "employeeCode is Required")
	private String status;

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public BaseDTO getDto() {


		EmployeeDTO dto = initDTO(new EmployeeDTO());

		dto.setEmployeeCode(employeeCode);
		dto.setEmployeeName(employeeName);
		dto.setStatus(status);
		dto.setDesignation(designation);
		
		return dto;
	
				
	}

}
