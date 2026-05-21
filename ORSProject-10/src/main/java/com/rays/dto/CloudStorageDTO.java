package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_cloud")
public class CloudStorageDTO extends BaseDTO{

	@Column(name = "fileName", length = 40)
	private String fileName;

	@Column(name = "fileSize", length = 40)
	private Double fileSize;

	@Column(name = "uploadDate", length = 30)
	private Date uploadDate;

	@Column(name = "userName", length = 30)
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
	public String getUniqueKey() {

		return "userName";
	}

	@Override
	public String getUniqueValue() {
		return userName;
	}

	@Override
	public String getLabel() {

		return "User Name";
	}

	@Override
	public String getTableName() {

		return "Cloud";
	}
	
	

}
