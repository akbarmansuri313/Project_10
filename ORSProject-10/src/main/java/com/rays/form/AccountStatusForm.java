package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.AccountStatusDTO;

public class AccountStatusForm extends BaseForm {

	@NotEmpty(message = "Account Code is Required")
	private String accountCode;

	@NotEmpty(message = "User Name Code is Required")
	private String userName;

	@NotEmpty(message = "Account Type is Required")
	private String accountType;

	@NotEmpty(message = "Status is Required")
	private String status;

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public BaseDTO getDto() {

		AccountStatusDTO dto = initDTO(new AccountStatusDTO());

		dto.setAccountCode(accountCode);
		dto.setStatus(status);
		dto.setUserName(userName);
		dto.setAccountType(accountType);

		return dto;
	}

}
