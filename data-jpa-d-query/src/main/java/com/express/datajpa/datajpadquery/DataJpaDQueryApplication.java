package com.express.datajpa.datajpadquery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DataJpaDQueryApplication {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext run = SpringApplication.run(DataJpaDQueryApplication.class, args)) {
			
			
			System.out.println("run11234");
		};
	}

}
