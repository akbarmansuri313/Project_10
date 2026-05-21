package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_geofence")
public class GeoFenceDTO extends BaseDTO{
	
	@Column(name = "geoFenceCode", length = 50)
	private String geoFenceCode;

	@Column(name = "locationName", length = 50)
	private String locationName;
	
	@Column(name = "radius", length = 50)
	private String radius;

	@Column(name = "status", length = 50)
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
	public String getUniqueKey() {

		return "locationName";
	}

	@Override
	public String getUniqueValue() {

		return locationName;
	}

	@Override
	public String getLabel() {

		return "Location Name";
	}

	@Override
	public String getTableName() {

		return "Geo Fence";
	}
	
	

}
