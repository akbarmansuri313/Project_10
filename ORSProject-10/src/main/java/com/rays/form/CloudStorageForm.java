package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.CloudStorageDTO;

public class CloudStorageForm extends BaseForm{
	

	@NotEmpty(message = "File Name is Required")
	private String fileName;

	@NotNull(message = "File Size is Required")
	private Double fileSize;

	@NotNull(message = "Upload Date is Required")
	private Date uploadDate;

	@NotEmpty(message = "User Name is Required")
	private String userName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Double getFileSize() {
		return fileSize;
	}

	public void setFileSize(Double fileSize) {
		this.fileSize = fileSize;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public BaseDTO getDto() {
		
		CloudStorageDTO dto = initDTO(new CloudStorageDTO());
		
		dto.setFileName(fileName);
		dto.setFileSize(fileSize);
		dto.setUploadDate(uploadDate);
		dto.setUserName(userName);
		
		return dto;
		
	}

}
