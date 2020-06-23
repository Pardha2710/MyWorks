package com.spring.mvc;

public class YogaBean {

	private String userName,emailId,gender,batch,city,contactNumber,age;
	private String[] yogaTypes;
	
	public String[] getYogaTypes() {
		return yogaTypes;
	}
	public void setYogaTypes(String[] yogaTypes) {
		this.yogaTypes = yogaTypes;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getUserName() {
		return userName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	
		
	
	
}
