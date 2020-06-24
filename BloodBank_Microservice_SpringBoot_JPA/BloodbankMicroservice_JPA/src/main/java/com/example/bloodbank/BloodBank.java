package com.example.bloodbank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

@Entity
@Validated
@Table(name="bloodbank")
public class BloodBank {
	
	@Id
	@Column(name="bbid")
	private int bbId;
	
	@Column(name="bloodbankname")
    @NotNull
    @Size(min=2, max=40)
	private String bloodBankName;
	
	@Column(name="address")
	@NotNull
	private String address;

	@Column(name="city")
	@NotNull
	private String city;
	
	@Column(name="phone")
	@NotNull
	private String phone;
	
	@Column(name="website")
	@NotNull
	private String website;
	
	@Column(name="email")
	@Email
	private String email;
	
	public BloodBank() {
		super();
	}
	
	public BloodBank(int bbId, String bloodBankName, String address, String city, String phone, String website,
			String email) {
		super();
		this.bbId = bbId;
		this.bloodBankName = bloodBankName;
		this.address = address;
		this.city = city;
		this.phone = phone;
		this.website = website;
		this.email = email;
	}

	public int getBbId() {
		return bbId;
	}

	public void setBbId(int bbId) {
		this.bbId = bbId;
	}

	public String getBloodBankName() {
		return bloodBankName;
	}

	public void setBloodBankName(String bloodBankName) {
		this.bloodBankName = bloodBankName;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

