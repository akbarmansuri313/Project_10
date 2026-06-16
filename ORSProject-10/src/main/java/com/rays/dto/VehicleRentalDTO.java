package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_vehicle")
public class VehicleRentalDTO extends BaseDTO{

	@Column(name = "customerName", length = 40)
	private String customerName;

	@Column(name = "vehicleType", length = 40)
	private String vehicleType;

	@Column(name = "rentPerDay", length = 40)
	private String rentPerDay;

	@Column(name = "totalDays", length = 40)
	private String totalDays;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getRentPerDay() {
		return rentPerDay;
	}

	public void setRentPerDay(String rentPerDay) {
		this.rentPerDay = rentPerDay;
	}

	public String getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(String totalDays) {
		this.totalDays = totalDays;
	}

	@Override
	public String getUniqueKey() {

		return "customerName";
	}

	@Override
	public String getUniqueValue() {

		return customerName;
	}

	@Override
	public String getLabel() {

		return "Customer Name";
	}

	@Override
	public String getTableName() {

		return "Vehicle";
	}
	
	

}
