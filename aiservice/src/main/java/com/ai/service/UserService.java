package com.ai.service;

import org.springframework.http.HttpHeaders;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ai.config.JwtUtil;
import com.ai.dto.UsersDto;
import com.ai.entity.Users;
import com.ai.exception.ApplicationException;
import com.ai.repository.UserRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	JwtUtil jwtUtil;

	public Users saveUser(UsersDto usersDto) {
		
	    Users user = new Users();
	    user.setName(usersDto.getName());
	    user.setPassword(usersDto.getPassword());
	    user.setEmailId(usersDto.getEmailId());
	    user.setMobile(usersDto.getMobile());
	    user.setRole(usersDto.getRole());

		userRepository.save(user);	
		return user;
	}
	
	
	public UsersDto login(UsersDto usersDto, HttpServletResponse res) throws Exception {
		Users user =null;
		user = userRepository.findByMobile(usersDto.getMobile());
		
		if(user !=null) {
			String pwd = user.getPassword();
			if(pwd.equals(usersDto.getPassword())) {
				Claims claims = Jwts.claims().setSubject(String.valueOf(user.getUserId()));
				claims.put("id", user.getUserId());
				claims.put("role", user.getRole().getRoleName());
				claims.put("mobile", user.getMobile());
				String token = jwtUtil.createToken(claims);
				res.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token);				
	                
				UsersDto usersData = new UsersDto();
				usersData.setUserId(user.getUserId());
				usersData.setName(user.getName());
				usersData.setEmailId(user.getEmailId());
				usersData.setMobile(user.getMobile());
				usersData.setRole(user.getRole());
				usersData.setToken(token);

				
				return usersData;
			}else {
				throw new ApplicationException(HttpStatus.UNAUTHORIZED, 1001, LocalDateTime.now(),
						"Invalid credentials");
			}
		}else {
			throw new ApplicationException(HttpStatus.UNAUTHORIZED, 1001, LocalDateTime.now(), "Invalid credentials");

		}
	}

}
