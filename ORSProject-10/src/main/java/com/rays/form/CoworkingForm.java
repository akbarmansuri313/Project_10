package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.CoworkingDTO;

public class CoworkingForm extends BaseForm {

	@NotEmpty(message = "Space Name is Required")
	private String spaceName;

	@NotEmpty(message = "location is Required")
	private String location;

	@NotEmpty(message = "Capacity is Required")
	private String capacity;

	@NotEmpty(message = "Rent is Required")
	private String rent;

	public String getSpaceName() {
		return spaceName;
	}

	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getRent() {
		return rent;
	}

	public void setRent(String rent) {
		this.rent = rent;
	}

	@Override
	public BaseDTO getDto() {

		CoworkingDTO dto = initDTO(new CoworkingDTO());

		dto.setCapacity(capacity);
		dto.setSpaceName(spaceName);
		dto.setRent(rent);
		dto.setLocation(location);

		return dto;
	}
}
