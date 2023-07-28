package com.seleniumexpress.jpaintro.springdatajpa01;

import com.seleniumexpress.jpaintro.springdatajpa01.dao.StudentDAO;
import com.seleniumexpress.jpaintro.springdatajpa01.entity.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpa01Application implements CommandLineRunner {

	@Autowired
	StudentDAO studentDAO;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpa01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		studentDAO.test();

	}

	
	
	
	
	
	
	
	
	private void namedParameterTesting() {
		List<Student> allStudent = studentDAO.findAllStudentWithFirstName("Vijay");
	    allStudent.forEach(student -> System.out.println(student));
	}
	
	
	
	
	
	
	

	private void findByIdTest() {
		Student student = studentDAO.findById(2);
		System.out.println("retrving student with id : 2 " + student);
	}

	public void saveStudent(){

		Student student = new Student();

		//student.setId(101);
		student.setStudentName("Vijay");
		student.setMobile(88888);
		student.setAddr("hyd");

		studentDAO.save(student);
	}
	
	public void saveStudentX(){

		Student student = new Student();

		//student.setId(101);
		student.setStudentName("Vijay");
		student.setMobile(88888);
		student.setAddr("hyd");

		studentDAO.save(student);
		
		Student student1 = new Student();

		//student.setId(101);
		student1.setStudentName("Abhilash");
		student1.setMobile(9999);
		student1.setAddr("blr");
		
		studentDAO.save(student1);
	}
}



















