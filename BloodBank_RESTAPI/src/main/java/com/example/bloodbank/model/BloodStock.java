package com.example.bloodbank.model;

import java.util.Date;

public class BloodStock {

	
private int bloodStockId;
	
	private String bloodGroup,status;
	private int quantity;
	private Date bestBefore;
	
	
	public BloodStock(int bloodStockId,String bloodGroup, String status, int quantity, Date bestBefore) {
		super();
		this.bloodStockId=bloodStockId;
		this.bloodGroup = bloodGroup;
		this.status = status;
		this.quantity = quantity;
		this.bestBefore = bestBefore;
	}
	public int getBloodStockId() {
		return bloodStockId;
	}
	public void setBloodStockId(int bloodStockId) {
		this.bloodStockId = bloodStockId;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getBestBefore() {
		return bestBefore;
	}
	public void setBestBefore(Date bestBefore) {
		this.bestBefore = bestBefore;
	}
	
	

}

