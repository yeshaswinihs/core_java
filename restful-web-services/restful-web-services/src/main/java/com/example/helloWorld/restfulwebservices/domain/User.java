package com.example.helloWorld.restfulwebservices.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQUENCE")
	@SequenceGenerator(name = "USER_SEQUENCE", allocationSize = 1)
	private Long id;
	@Column
	private String name;
	@Column
	private String userName;
	@Column
	private String password;
	@Column
	private String confirmPassword;
	@Column
	private String email;
	@Column
	private Long phone;
	@Column
	private String topic;
	@Column
	private String timePreference;
	@Column
	private boolean subscribe;
//	@Column
//	private String alternateEmails;

//	 @JoinColumn annotation to configure the name of the column in the users table that maps to the primary key in the address table.
//	whoever owns the foreign key column gets the @JoinColumn annotation.
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
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

//	public String getAlternateEmails() {
//		return alternateEmails;
//	}
//
//	public void setAlternateEmails(String alternateEmails) {
//		this.alternateEmails = alternateEmails;
//	}

}
