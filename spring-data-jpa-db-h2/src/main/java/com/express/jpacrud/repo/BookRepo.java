package com.express.jpacrud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.express.jpacrud.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{

}
