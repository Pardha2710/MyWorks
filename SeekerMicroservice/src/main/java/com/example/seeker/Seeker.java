package com.example.seeker;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

@Entity
@Validated
@Table(name="seeker_patient")
public class Seeker {

	@Id
	@Column(name="spid")
	private int spId;
	
	@NotNull
	@Column(name="firstname")
	private String firstName;
	
	@NotNull
	@Column(name="lastname")
	private String lastName;
	
	@NotNull
	@Column(name="age")
	private int age;
	
	@NotNull
	@Column(name="gender")
	private String gender;
	
	@NotNull
	@Column(name="bloodgroup")
	private String bloodGroup;
	
	@NotNull
	@Column(name="city")
	private String city;
	
	@NotNull
	@Column(name="phone")
	private String phone;
	
	public Seeker() {
		super();
	}
	public Seeker(int spId, String firstName, String lastName, int age, String gender, String bloodGroup,
			String city, String phone) {
		super();
		this.spId = spId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.city = city;
		this.phone = phone;
	}
	public int getSpId() {
		return spId;
	}
	public void setSpId(int spId) {
		this.spId = spId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
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
	
}
