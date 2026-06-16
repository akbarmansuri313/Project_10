package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.VehicleRentalDTO;

public class VehicleRentalForm extends BaseForm{

	@NotEmpty(message = "Customer Name is Required")
	private String customerName;

	@NotEmpty(message = "Vehicle Type is Required")
	private String vehicleType;

	@NotEmpty(message = "Rent PerDay is Required")
	private String rentPerDay;

	@NotEmpty(message = "Total Days is Required")
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
	public BaseDTO getDto() {
		
		
		VehicleRentalDTO dto = initDTO(new VehicleRentalDTO());
		
		dto.setVehicleType(vehicleType);
		dto.setTotalDays(totalDays);
		dto.setRentPerDay(rentPerDay);
		dto.setCustomerName(customerName);
		
		return dto;
	}

}
