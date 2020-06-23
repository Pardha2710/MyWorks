package com.example.bloodstock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

@Entity
@Validated
@Table(name="bloodstock")
public class BloodStock {
	
	@Id
	@Column(name="bsid")
	private int bsId;
	
	@Column(name="bloodgroup")
    @NotNull
    @Size(min=2, max=2)
	private String bloodGroup;
	
	@Column(name="quantity")
    @NotNull
	private int quantity;
	
	@Column(name="bestbefore")
    @NotNull
	private String bestBefore;
	
	@Column(name="status")
    @NotNull
	private String status;
	
	public BloodStock() {
		super();
	}
	
	public BloodStock(int bsId, String bloodGroup, int quantity, String bestBefore, String status) {
		super();
		this.bsId = bsId;
		this.bloodGroup = bloodGroup;
		this.quantity = quantity;
		this.bestBefore = bestBefore;
		this.status = status;
	}
	public int getBsId() {
		return bsId;
	}

	public void setBsId(int bsId) {
		this.bsId = bsId;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getBestBefore() {
		return bestBefore;
	}
	public void setBestBefore(String bestBefore) {
		this.bestBefore = bestBefore;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
