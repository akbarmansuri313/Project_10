package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_profile")
public class UserProfileDTO extends BaseDTO{
	
	@Column(name = "profileCode", length = 50)
	private String profileCode; 

	@Column(name = "userName", length = 50)
	private String userName;
	
	@Column(name = "mobileNumber", length = 50)
	private String mobileNumber;
	
	@Column(name = "status", length = 50)
	private String status;

	public String getProfileCode() {
		return profileCode;
	}

	public void setProfileCode(String profileCode) {
		this.profileCode = profileCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getUniqueKey() {

		return "profileCode";
	}

	@Override
	public String getUniqueValue() {

		return profileCode;
	}

	@Override
	public String getLabel() {

		return "profileCode";
	}

	@Override
	public String getTableName() {

		return "User Profile";
	}
	
	
	
}
