package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.FoodOrderDTO;

public class FoodOrderForm extends BaseForm {

	@NotEmpty(message = "Customer Name is Reuired")
	private String customerName;

	@NotEmpty(message = "Food Item is Reuired")
	private String foodItem;

	@NotNull(message = "Quantity is Reuired")
	private int quantity;

	@NotEmpty(message = "Total Amount is Reuired")
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
	public BaseDTO getDto() {

		FoodOrderDTO dto = initDTO(new FoodOrderDTO());

		dto.setTotalAmount(totalAmount);
		dto.setQuantity(quantity);
		dto.setCustomerName(customerName);
		dto.setFoodItem(foodItem);

		return dto;

	}
}
