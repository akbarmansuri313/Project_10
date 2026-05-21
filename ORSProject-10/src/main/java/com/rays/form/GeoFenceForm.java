package com.rays.form;


import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.GeoFenceDTO;

public class GeoFenceForm extends BaseForm{

	@NotEmpty(message = "geoFenceCode is Required")
	private String geoFenceCode;

	@NotEmpty(message = "locationName is Required")
	private String locationName;

	@NotEmpty(message = "radius is Required")
	private String radius;

	@NotEmpty(message = "status is Required")
	private String status;

	public String getGeoFenceCode() {
		return geoFenceCode;
	}

	public void setGeoFenceCode(String geoFenceCode) {
		this.geoFenceCode = geoFenceCode;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getRadius() {
		return radius;
	}

	public void setRadius(String radius) {
		this.radius = radius;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Override
	public BaseDTO getDto() {
		
		GeoFenceDTO dto = initDTO(new GeoFenceDTO());
		
		dto.setGeoFenceCode(geoFenceCode);
		dto.setRadius(radius);
		dto.setStatus(status);
		dto.setLocationName(locationName);
		
		return dto;
	}

}
