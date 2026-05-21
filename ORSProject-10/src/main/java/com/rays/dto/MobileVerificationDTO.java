package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_mobile")
public class MobileVerificationDTO extends BaseDTO{
	
	@Column(name = "verificationCode", length = 20)
	private String verificationCode;

	@Column(name = "mobileNumber", length = 20)
	private String  mobileNumber;

	@Column(name = "otp", length = 20)
	private String  otp;

	@Column(name = "status", length = 20)
	private String  status;

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getUniqueKey() {

		return "verificationCode";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return verificationCode;
	}

	@Override
	public String getLabel() {

		return "Verification Code";
	}

	@Override
	public String getTableName() {

		return "Mobile Verification";
	}
	
	

}
