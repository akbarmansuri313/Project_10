package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;


@Entity
@Table(name = "st_petadoption")
public class PetAdoptionDTO extends BaseDTO{
	
	@Column(name = "petName", length = 40)
	private String petName;
	
	@Column(name = "breed", length = 40)
	private String breed;
	
	@Column(name = "age", length = 40)
	private String age;
	
	@Column(name = "status", length = 40)
	private String status;

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getUniqueKey() {

		return "petName";
	}

	@Override
	public String getUniqueValue() {

		return petName;
	}

	@Override
	public String getLabel() {

		return "Pet Name";
	}

	@Override
	public String getTableName() {

		return "Pet Adoption";
	}
	
	

	
}
