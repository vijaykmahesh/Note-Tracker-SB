package com.express.datajpa.datajpadquery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.express.datajpa.datajpadquery.entity.Employee;
import com.express.datajpa.datajpadquery.repo.EmployeeRepository;

@DataJpaTest
class DataJpaDQueryApplicationTests {
	
	@Autowired
	EmployeeRepository repository;

	@Test
	void contextLoads() {
	}
	
	@Test
	void test1() {
		
		
		Employee employee = repository.findByName("Harsha");
		
		System.out.println(employee);
	}

}
