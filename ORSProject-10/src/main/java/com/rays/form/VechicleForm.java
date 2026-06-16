package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.VechicleDTO;

public class VechicleForm extends BaseForm {

	@NotEmpty(message = "vechicleName is Required")
	private String vechicleName;

	@NotEmpty(message = "company is Required")
	private String company;

	@NotEmpty(message = "model is Required")
	private String model;

	@NotEmpty(message = "price is Required")
	private String price;

	public String getVechicleName() {
		return vechicleName;
	}

	public void setVechicleName(String vechicleName) {
		this.vechicleName = vechicleName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	
	@Override
	public BaseDTO getDto() {
		
		VechicleDTO dto = initDTO(new VechicleDTO());
		
		dto.setModel(model);
		dto.setVechicleName(vechicleName);
		dto.setPrice(price);
		dto.setCompany(company);
		
		return dto;
		
	}
}
