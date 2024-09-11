package com.ai.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users") 
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "name",nullable = false)
	private String name;
	
	@Column(name = "password",nullable = false)
	private String password;
	
	@Column(name = "email",nullable = false)
	private String emailId;
	
	@Column(name = "mobile",nullable = false)
	private Long  mobile;
	
	@ManyToOne
	@JoinColumn(name = "user_role", referencedColumnName = "role_id")
	private Role role;

}
