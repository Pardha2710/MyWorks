package com.example.bloodbank.model;

public class BloodBank {
	
	private int bloodBanbkId;
	private String bloodbankName,address,city,phoneNumber,website,email;
	
	public BloodBank(int bloodBanbkId,String bloodbankName, String address, String city, String phoneNumber, String website,
			String email) {
		super();
		this.bloodBanbkId=bloodBanbkId;
		this.bloodbankName = bloodbankName;
		this.address = address;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.website = website;
		this.email = email;
	}

	public int getBloodBanbkId() {
		return bloodBanbkId;
	}

	public void setBloodBanbkId(int bloodBanbkId) {
		this.bloodBanbkId = bloodBanbkId;
	}

	public String getBloodbankName() {
		return bloodbankName;
	}

	public void setBloodbankName(String bloodbankName) {
		this.bloodbankName = bloodbankName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}

