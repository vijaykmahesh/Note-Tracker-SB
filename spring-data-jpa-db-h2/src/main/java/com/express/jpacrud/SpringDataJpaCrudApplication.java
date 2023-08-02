package com.express.jpacrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.express.jpacrud.entity.Book;
import com.express.jpacrud.repo.BookRepo;

@SpringBootApplication
public class SpringDataJpaCrudApplication {
	
	@Autowired
	BookRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaCrudApplication.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner() {
		
			
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				
				System.out.println("Hello world");
				
				repo.save(new Book("JUNIT", "SAVAS"));
				
			}
		};
		
	}

}
