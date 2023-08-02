package com.express;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.express.dao.StudentDAO;
import com.express.entity.Student;

@SpringBootApplication
public class SpringDataJpa01Application implements CommandLineRunner {
	
	@Autowired
	StudentDAO studentDAO;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpa01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		saveStudent();
//		
//		studentDAO.findAllStudents();
//		
//		studentDAO.findStudentWithStudentName("vijay");
		
		studentDAO.test();
		
		studentDAO.mergeMethod();
		
	}

	private void saveStudent() {
		Student student = new Student();
		
		student.setId(3);
		student.setName("akash");
		student.setAddress("shimoga");
		student.setMobile(269872639);
		
		studentDAO.save(student);
	}

	
}
