package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_server")
public class ServerMonitorDTO extends BaseDTO {

	@Column(name = "cpuUsage", length = 30)
	private String cpuUsage;

	@Column(name = "ramUsage", length = 30)
	private Double ramUsage;

	@Column(name = "uptime", length = 30)
	private String uptime;

	@Column(name = "status", length = 30)
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
	public String getUniqueKey() {

		return "cpuUsage";
	}

	@Override
	public String getUniqueValue() {
		return cpuUsage;
	}

	@Override
	public String getLabel() {

		return "Cpu Usage";
	}

	@Override
	public String getTableName() {

		return "Server";

	}

}
