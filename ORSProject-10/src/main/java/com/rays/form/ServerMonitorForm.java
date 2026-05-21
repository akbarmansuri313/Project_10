package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.ServerMonitorDTO;

public class ServerMonitorForm extends BaseForm {

	@NotEmpty(message = "Cpu Usage is Required")
	private String cpuUsage;

	@NotNull(message = "Ram Usage is Required")
	private Double ramUsage;

	@NotNull(message = "Up Time is Required")
	private String uptime;

	@NotEmpty(message = "Status is Required")
	private String status;

	public String getCpuUsage() {
		return cpuUsage;
	}

	public void setCpuUsage(String cpuUsage) {
		this.cpuUsage = cpuUsage;
	}

	public Double getRamUsage() {
		return ramUsage;
	}

	public void setRamUsage(Double ramUsage) {
		this.ramUsage = ramUsage;
	}

	public String getUptime() {
		return uptime;
	}

	public void setUptime(String uptime) {
		this.uptime = uptime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public BaseDTO getDto() {
		
		ServerMonitorDTO dto = initDTO(new ServerMonitorDTO());
		
		dto.setCpuUsage(cpuUsage);
		dto.setRamUsage(ramUsage);
		dto.setUptime(uptime);
		dto.setStatus(status);
		
		return dto;
	}

}
