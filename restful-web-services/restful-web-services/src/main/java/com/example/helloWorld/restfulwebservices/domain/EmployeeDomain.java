package com.example.helloWorld.restfulwebservices.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class EmployeeDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_SEQUENCE")
	@SequenceGenerator(name= "EMPLOYEE_SEQUENCE", allocationSize = 1)
	private long id;
	
	@Column
	private String namo;
	
	@Column
	private long age;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public String getNamo() {
		return namo;
	}

	public void setNamo(String namo) {
		this.namo = namo;
	}

//	public String getNamo() {
//		return namo;
//	}
//
//	public void setNamo(String namo) {
//		this.namo = namo;
//	}
	
	
	
	

}
