package com.example.accessingdatamysql;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {
	@Id
    @GeneratedValue
    private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String email;
	
	public enum Role{
		PROJECT_MANAGER,
		DEVELOPER;
	}
	
	@NotBlank
	private Role role;
	
	public User() {
		super();
	}

	public User(Long id, @NotBlank String name, @NotBlank String email, @NotBlank Role role) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
	}

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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
}
