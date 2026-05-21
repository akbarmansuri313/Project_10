package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.UserProfileDTO;


public class UserProfileForm extends BaseForm{
	
	@NotEmpty(message = "Profile Code is Required")
	private String profileCode; 

	@NotEmpty(message = "User Name is Required")
	private String userName;
	
	@NotEmpty(message = "Mobile Number is Required")
	private String mobileNumber;
	
	@NotEmpty(message = "status is Required")
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
	public BaseDTO getDto() {
		
		UserProfileDTO dto = initDTO(new UserProfileDTO());
		
		dto.setProfileCode(profileCode);
		dto.setStatus(status);
		dto.setUserName(userName);
		dto.setMobileNumber(mobileNumber);
		
		return dto;
	}
	

}
