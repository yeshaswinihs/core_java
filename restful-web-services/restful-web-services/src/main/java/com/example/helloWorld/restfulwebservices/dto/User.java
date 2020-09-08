package com.example.helloWorld.restfulwebservices.dto;

public class User {

	private Long id;
	private String name;
	private String email;
	private Long phone;
	private String topic;
	private String timePreference;
	private boolean subscribe;

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

}
