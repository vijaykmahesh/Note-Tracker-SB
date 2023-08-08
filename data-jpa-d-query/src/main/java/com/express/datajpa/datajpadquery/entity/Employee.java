package com.express.datajpa.datajpadquery.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Integer id;

	@Column(name = "employee_name")
	private String name;

	@Column(name = "employee_email")
	private String email;

	@Column(name = "employee_address")
	private String address;

}
