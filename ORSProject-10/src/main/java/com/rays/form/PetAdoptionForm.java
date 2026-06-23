package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.PetAdoptionDTO;

public class PetAdoptionForm extends  BaseForm {

	@NotEmpty(message = "Pet Name is Required")
	private String petName;

	@NotEmpty(message = "Breed is Required")
	private String breed;

	@NotEmpty(message = "Age is Required")
	private String age;

	@NotEmpty(message = "Status is Required")
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
	public BaseDTO getDto() {
		
		PetAdoptionDTO dto = new PetAdoptionDTO();
		
		dto.setAge(age);
		dto.setPetName(petName);
		dto.setStatus(status);
		dto.setBreed(breed);
		
		return dto;
	}
	
	
}
