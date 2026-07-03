package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_recommendation")
public class RecommendationDTO extends BaseDTO{
	
	@Column(name = "recommendationCode", length = 30)
	private String recommendationCode;
	
	@Column(name = "userName", length = 30)
	private String userName;
	
	@Column(name = "recommendationType", length = 30)
	private String recommendationType;
	
	@Column(name = "status", length = 30)
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
	public String getUniqueKey() {

		return "recommendationCode";
	}

	@Override
	public String getUniqueValue() {

		return recommendationCode;
	}

	@Override
	public String getLabel() {

		return "Recommendation Code";
	}

	@Override
	public String getTableName() {
		return "Recommendation";
	}
	
	
	
	

}
