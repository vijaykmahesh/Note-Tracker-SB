package com.seleniumexpress.notetracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig {
	
	
	@Bean
	InMemoryUserDetailsManager createUser(){
		
		UserDetails abhi = User.withDefaultPasswordEncoder()
				                    .username("vijay")
									.password("vijay")
									.roles("admin")
									.build();
		
		
		
		
		InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager(abhi);
		
		return userDetailsManager;
		
	}

}
