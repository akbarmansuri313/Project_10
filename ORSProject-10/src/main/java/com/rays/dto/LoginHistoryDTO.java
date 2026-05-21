package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "login")
public class LoginHistoryDTO extends BaseDTO{

	@Column(name = "historyCode", length = 50)
	private String historyCode;
	
	@Column(name = "userName", length = 50)
	private String userName;
	
	@Column(name = "Date", length = 50)
	private String Date;
	
	@Column(name = "status", length = 50)
	private String status;

	public String getHistoryCode() {
		return historyCode;
	}

	public void setHistoryCode(String historyCode) {
		this.historyCode = historyCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getUniqueKey() {

		return "historyCode";
	}

	@Override
	public String getUniqueValue() {

		return historyCode;
	}

	@Override
	public String getLabel() {

		return "History Code";
	}

	@Override
	public String getTableName() {

		return "Login History";
	}
	
	
}
