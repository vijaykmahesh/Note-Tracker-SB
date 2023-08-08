package com.express.datajpa.datajpadquery.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.express.datajpa.datajpadquery.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	Employee findByName(String name);

}
