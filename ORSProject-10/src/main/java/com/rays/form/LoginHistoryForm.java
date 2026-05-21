package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.LoginHistoryDTO;

public class LoginHistoryForm extends BaseForm {

	@NotEmpty(message = "History Code is Erquired")
	private String historyCode;

	@NotEmpty(message = "User Name Code is Erquired")
	private String userName;

	@NotEmpty(message = "Date is required")
	private String Date;

	@NotEmpty(message = "status Code is Erquired")
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
	public BaseDTO getDto() {

		LoginHistoryDTO dto = initDTO(new LoginHistoryDTO());

		dto.setHistoryCode(historyCode);
		dto.setStatus(status);

		dto.setUserName(userName);
		dto.setDate(Date);

		return dto;

	}

}
