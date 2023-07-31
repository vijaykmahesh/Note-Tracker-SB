package com.express.jpacrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.express.jpacrud.entity.Book;
import com.express.jpacrud.repo.BookRepo;

@SpringBootApplication
public class SpringDataJpaCrudApplication implements CommandLineRunner {

	@Autowired
	BookRepo repo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//updateBook();
		
		deleteBook();
	}

	public void deleteBook() {
		
		Book book = new Book();
		
		book.setBookName("teams");
		book.setAuthor("sri");
		
		Book returnedBook = repo.save(book); // persist()
		
		repo.delete(returnedBook);
		
	}
	public void updateBook() {
		
		Book book = new Book();
		
		book.setBookName("bhagvatgitha");
		book.setAuthor("seetha");
		
		Book returnedBook = repo.save(book); // persist()
		
		returnedBook.setBookName("bhagvatgitha 2.0");
		
		repo.save(returnedBook); // merge()
	}

}
