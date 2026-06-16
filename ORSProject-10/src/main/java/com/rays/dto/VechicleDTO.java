package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_vechicle")
public class VechicleDTO extends BaseDTO {
	
	@Column(name = "vechicleName", length = 30)
	private String vechicleName;
	
	@Column(name = "company", length = 30)
	private String company;
	
	@Column(name = "model", length = 30)
	private String model;
	
	@Column(name = "price", length = 30)
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
	public String getUniqueKey() {

		return "model";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return model;
	}

	@Override
	public String getLabel() {

		return "Model";
	}

	@Override
	public String getTableName() {

		return "Vechicle";
	}
	
	

}
