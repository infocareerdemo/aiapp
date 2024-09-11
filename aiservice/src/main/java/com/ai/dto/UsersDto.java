package com.ai.dto;

import com.ai.entity.Role;

import lombok.Data;

@Data
public class UsersDto {
	
	
	private Long userId;
	
	private String name;
	
	private String password;
	
	private String emailId;
	
	private Long  mobile;
	
	private Role role;
	
	private String token;
	



}
