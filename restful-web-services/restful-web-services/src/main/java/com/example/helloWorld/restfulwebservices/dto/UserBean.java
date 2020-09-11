package com.example.helloWorld.restfulwebservices.dto;

import java.util.List;

public class UserBean {

	private Long id;
	private String name;
	private String email;
	private Long phone;
	private String topic;
	private String timePreference;
	private boolean subscribe;
	private String userName;
	private String password;
	private String confirmPassword;
	private AddressBean address;
//	private List<String> alternateEmails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getTimePreference() {
		return timePreference;
	}

	public void setTimePreference(String timePreference) {
		this.timePreference = timePreference;
	}

	public boolean isSubscribe() {
		return subscribe;
	}

	public void setSubscribe(boolean subscribe) {
		this.subscribe = subscribe;
	}

	public AddressBean getAddress() {
		return address;
	}

	public void setAddress(AddressBean address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

//	public List<String> getAlternateEmails() {
//		return alternateEmails;
//	}
//
//	public void setAlternateEmails(List<String> alternateEmails) {
//		this.alternateEmails = alternateEmails;
//	}

}
