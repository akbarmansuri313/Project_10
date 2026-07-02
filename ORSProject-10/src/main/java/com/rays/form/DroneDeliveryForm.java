package com.rays.form;


import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.DroneDeliveryDTO;

public class DroneDeliveryForm extends BaseForm{
	
	@NotEmpty(message = "drone Code is required")
	private String droneCode;
	
	@NotEmpty(message = "Operator Name is required")
	private String operatorName;
	
	@NotEmpty(message = "Delivery Zone is required")
	private String deliveryZone;
	
	@NotEmpty(message = "status is required")
	private String status;

	public String getDroneCode() {
		return droneCode;
	}

	public void setDroneCode(String droneCode) {
		this.droneCode = droneCode;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getDeliveryZone() {
		return deliveryZone;
	}

	public void setDeliveryZone(String deliveryZone) {
		this.deliveryZone = deliveryZone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	@Override
	public BaseDTO getDto() {
		
		DroneDeliveryDTO dto = initDTO(new DroneDeliveryDTO());
		
		dto.setDroneCode(droneCode);
		dto.setDeliveryZone(deliveryZone);
		dto.setOperatorName(operatorName);
		dto.setStatus(status);
		
		return dto;
	}

}
