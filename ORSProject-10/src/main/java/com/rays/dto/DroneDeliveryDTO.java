package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_drone")
public class DroneDeliveryDTO extends BaseDTO{
	
	@Column(name = "droneCode", length = 40)
	private String droneCode;
	
	@Column(name = "operatorName", length = 40)
	private String operatorName;
	
	@Column(name = "deliveryZone", length = 40)
	private String deliveryZone;
	
	@Column(name = "status", length = 40)
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
	public String getUniqueKey() {

		return "droneCode";
	}

	@Override
	public String getUniqueValue() {

		return droneCode;
	}

	@Override
	public String getLabel() {

		return "Drone Code";
	}

	@Override
	public String getTableName() {

		return "Drone";
	}
	
	
	

}
