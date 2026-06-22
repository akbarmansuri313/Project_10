package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_coworking")
public class CoworkingDTO extends BaseDTO {

	@Column(name = "spaceName", length = 40)
	private String spaceName;

	@Column(name = "location", length = 40)
	private String location;

	@Column(name = "capacity", length = 40)
	private String capacity;

	@Column(name = "rent", length = 40)
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
	public String getUniqueKey() {

		return "spaceName";
	}

	@Override
	public String getUniqueValue() {
		return spaceName;
	}

	@Override
	public String getLabel() {

		return "Space Name";
	}

	@Override
	public String getTableName() {

		return "Coworking";
	}

}
