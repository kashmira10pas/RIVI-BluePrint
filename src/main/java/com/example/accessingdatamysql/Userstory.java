package com.example.accessingdatamysql;


import java.util.Date;
//import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;



@Entity
@Table(name = "userstory")
public class Userstory {
	@Id
  @GeneratedValue
  private Long id;
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String description;
	
	@NotBlank
	private Date date;
	
	@NotBlank
	@ManyToOne(cascade = CascadeType.ALL)
	private User assignedTo;
	
	private enum State{
		DISCOVERY,
		DEFINED,
		IN_PROGRESS,
		COMPLETE;
	}
	@NotBlank
	private State state;
	
	public Userstory() {
		super();
	}
	
	public Userstory(Long id, @NotBlank String title, @NotBlank String description, @NotBlank Date date,
			@NotBlank User assignedTo, @NotBlank State state) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
		this.assignedTo = assignedTo;
		this.state = State.DISCOVERY;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	

	
	
	
}
