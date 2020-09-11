package com.example.helloWorld.restfulwebservices.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESS_SEQUENCE")
	@SequenceGenerator(name = "ADDRESS_SEQUENCE", allocationSize = 1)
	private Long id;
	@Column
	private String state;
	@Column
	private String city;
	@Column
	private String postalCode;

//	To establish bi-directional relationship. The address side of the relationship is called the non-owning side. 
	@OneToOne(mappedBy = "address")
	private User user;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}
