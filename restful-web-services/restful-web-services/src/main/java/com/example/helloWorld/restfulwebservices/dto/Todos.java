package com.example.helloWorld.restfulwebservices.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "todo")
public class Todos {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TODO_SEQUENCE")
	@SequenceGenerator(name = "TODO_SEQUENCE", allocationSize = 1)
	private long id;

	@Column
	private String username;

	@Column
	private String description;

	@Column(name = "target_date")
	private Date targetDate;

	@Column(name = "is_completed")
	private boolean isCompleted;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public Todos() {
		super();
	}

	public Todos(long id, String username, String description, Date targetDate, boolean isCompleted) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.isCompleted = isCompleted;
	}

	public Todos(String username, String description, Date targetDate, boolean isCompleted) {
		super();
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.isCompleted = isCompleted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todos other = (Todos) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
