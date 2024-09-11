package com.ai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		System.out.println("Security Config");
		http.csrf(httpCsrf -> httpCsrf.disable())
				.authorizeHttpRequests(req -> req
						.requestMatchers(
								"/api/v1/user/save",
								"/api/v1/user/login"					    

								
								)
						.permitAll().anyRequest().authenticated())
				.addFilterBefore(new JwtAuthentication(), BasicAuthenticationFilter.class);
		return http.build();
	}
}
