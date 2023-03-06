package com.model;

public class Customer {

	private String customer_ID,customer_name,Gender,Email_ID,address;
	private long Mobile_number;
	public String getCustomer_ID() {
		return customer_ID;
	}
	public void setCustomer_ID(String customer_ID) {
		this.customer_ID = customer_ID;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getEmail_ID() {
		return Email_ID;
	}
	public void setEmail_ID(String email_ID) {
		Email_ID = email_ID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobile_number() {
		return Mobile_number;
	}
	public void setMobile_number(long mobile_number) {
		Mobile_number = mobile_number;
	}
	
}
