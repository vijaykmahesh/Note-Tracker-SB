package com.seleniumexpress.notetracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.seleniumexpress.notetracker.example.Example1;


@Configuration //(proxyBeanMethods = false)
public class NoteTrackerAppConfig {
//	
//	@Bean
//	DataSource dataSource() {
//		
//		return new DriverManagerDataSource("jdbc:mysql://localhost:3306/notetracker", "root", "abhilash");
//	}
//	
//	
//	@Bean
//	JdbcTemplate jdbTemplate(@Autowired DataSource dataSource) {
//		
//		return new JdbcTemplate(dataSource);
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Bean
	Example1 example1(){
		
		return new Example1();
	}
	
	
}


