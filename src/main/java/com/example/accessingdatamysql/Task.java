package com.example.accessingdatamysql;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name = "tasks")
public class Task {
	
	@Id
    @GeneratedValue
    private Long id;
	@NotBlank
	private String title;
	@NotBlank
	private String description;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User assignedTo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Userstory assignedToStory;
	
	public Task() {
		super();
	}

	public Task(Long id, String title, String description, User assignedTo, Userstory assignedToStory) {
		//public Task(Long id, String title, String description, Usertest ut) {

		
		this.id = id;
		this.title = title;
		this.description = description;
		//this.ut=ut;
		this.assignedTo = assignedTo;
		this.assignedToStory = assignedToStory;
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
	
//	public Usertest getut() {
//		return ut;
//	}
//
//	public void setut(Usertest assignedTo) {
//		this.ut = assignedTo;
//	}


	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Userstory getAssignedToStory() {
		return assignedToStory;
	}

	public void setAssignedToStory(Userstory assignedToStory) {
		this.assignedToStory = assignedToStory;
	}
	
	
	
	
	
	
	
	

}
