package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_food")
public class FoodOrderDTO extends BaseDTO{

	@Column(name = "customerName", length = 30)
	private String customerName;
	
	@Column(name = "foodItem", length = 30)
	private String foodItem;
	
	@Column(name = "quantity", length = 30)
	private int quantity;
	
	@Column(name = "totalAmount", length = 30)
	private String totalAmount;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getFoodItem() {
		return foodItem;
	}

	public void setFoodItem(String foodItem) {
		this.foodItem = foodItem;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
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

		return "customerName";
	}

	@Override
	public String getTableName() {

		return "Food Order";
	}
	
	
	
}
