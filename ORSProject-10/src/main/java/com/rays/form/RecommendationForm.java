package com.rays.form;


import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.RecommendationDTO;

public class RecommendationForm extends BaseForm{

	
	@NotEmpty(message = "Recommendation Code is Required")
	private String recommendationCode;
	
	@NotEmpty(message = "User Name is Required")
	private String userName;
	
	@NotEmpty(message = "Recommendation Type is Required")
	private String recommendationType;
	
	@NotEmpty(message = "status is Required")
	private String status;

	public String getRecommendationCode() {
		return recommendationCode;
	}

	public void setRecommendationCode(String recommendationCode) {
		this.recommendationCode = recommendationCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRecommendationType() {
		return recommendationType;
	}

	public void setRecommendationType(String recommendationType) {
		this.recommendationType = recommendationType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public BaseDTO getDto() {
		
		RecommendationDTO dto = initDTO(new RecommendationDTO());
		
		dto.setUserName(userName);
		dto.setStatus(status);
		dto.setRecommendationCode(recommendationCode);
		dto.setRecommendationType(recommendationType);
		
		return dto;
	}
	
	
}
