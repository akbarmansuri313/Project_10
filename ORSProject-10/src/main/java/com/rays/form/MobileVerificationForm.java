package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.MobileVerificationDTO;

public class MobileVerificationForm extends BaseForm {

	@NotEmpty(message = "Verification Code is Required")
	private String verificationCode;

	@NotEmpty(message = "Mobile Number is Required")
	private String mobileNumber;

	@NotEmpty(message = "Otp is Required")
	private String otp;

	@NotEmpty(message = "Status is Required")
	private String status;

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
	public BaseDTO getDto() {
		
		MobileVerificationDTO dto = initDTO(new MobileVerificationDTO());
		
		dto.setMobileNumber(mobileNumber);	
		dto.setVerificationCode(verificationCode);
		dto.setStatus(status);
		dto.setOtp(otp);
		
		return dto;
	}

}
