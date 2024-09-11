package com.ai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ai.dto.UsersDto;
import com.ai.entity.Users;
import com.ai.service.UserService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/save")
	public Users saveUser(@RequestBody UsersDto usersDto)throws Exception{
		Users  users = userService.saveUser(usersDto);
		return users;		
	}
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody UsersDto usersDto,HttpServletResponse response) throws Exception {
		return new ResponseEntity<Object>(userService.login(usersDto,response), HttpStatus.OK);
	}

}
