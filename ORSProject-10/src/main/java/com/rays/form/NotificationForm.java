package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.NotificationDTO;


public class NotificationForm extends BaseForm{
	
	@NotNull(message = "notificationId is required")
	@Min(1)
	protected Long notificationId;
	
	@NotEmpty(message = "Title is Required")
	protected String title;
	
	@NotEmpty(message = "Message is Required")
	protected String message;
	
	@NotNull(message = "sentDate is Required")
	protected Date sentDate;
	
	@NotNull(message = "isResd")
	protected Boolean isRead;


	

	public Long getNotificationId() {
		return notificationId;
	}






	public void setNotificationId(Long notificationId) {
		this.notificationId = notificationId;
	}






	public String getTitle() {
		return title;
	}






	public void setTitle(String title) {
		this.title = title;
	}






	public String getMessage() {
		return message;
	}






	public void setMessage(String message) {
		this.message = message;
	}






	public Date getSentDate() {
		return sentDate;
	}






	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}







	
	public Boolean getIsRead() {
		return isRead;
	}






	public void setIsRead(Boolean isRead) {
		this.isRead = isRead;
	}






	@Override
	public BaseDTO getDto() {
		
		NotificationDTO dto = initDTO(new NotificationDTO());
		dto.setNotificationId(notificationId);
		dto.setTitle(title);
		dto.setMessage(message);
		dto.setSentDate(sentDate);
		dto.setIsRead(isRead);
		return dto;
	
}
}
