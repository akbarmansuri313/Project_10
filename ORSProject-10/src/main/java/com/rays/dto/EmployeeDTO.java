package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_employee")
public class EmployeeDTO extends BaseDTO {

	@Column(name = "employeeCode", length = 50)
	private String employeeCode;

	@Column(name = "employeeName", length = 50)
	private String employeeName;

	@Column(name = "designation", length = 50)
	private String designation;

	@Column(name = "status", length = 50)
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
	public String getUniqueKey() {
		return "employeeCode";
	}

	@Override
	public String getUniqueValue() {

		return employeeCode;
	}

	@Override
	public String getLabel() {

		return "Employee Code";
	}

	@Override
	public String getTableName() {

		return "Employee";
	}
}
