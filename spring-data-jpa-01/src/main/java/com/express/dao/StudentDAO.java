package com.express.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.express.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAO {

	@Autowired
	EntityManager entityManager; // spring will automatically create object

	@Transactional
	public void save(Student student) {

		Session sessionUnwrapping = entityManager.unwrap(Session.class);

		System.out.println(sessionUnwrapping);

		entityManager.persist(student);

	}

	public void findAllStudents() {

		// select * from test01.students --> sql
		// from Student --> JPQL

		List<Student> studentList = null;

		TypedQuery<Student> query = entityManager.createQuery("from Student", Student.class);

		studentList = query.getResultList();

		System.out.println(studentList);

	}

	public void findStudentWithStudentName(String studentName) {

		// select * from test01.students --> sql
		// from Student --> JPQL

		List<Student> studentList = null;

		TypedQuery<Student> query = entityManager.createQuery("from Student where name=:name", Student.class);
		query.setParameter("name", studentName);

		studentList = query.getResultList();

		System.out.println(studentList);

	}

	@Transactional
	public void test() {

		Student student = new Student();
		
		student.setId(1);
		student.setName("vijay");
		student.setAddress("blr");
		student.setMobile(787585765);
		

		entityManager.persist(student);
		
		// now this object i,e student object will be tracked by entityManager i,e persistence context
		// for any further changes we make in the object.  
		
		student.setName("vijay k");
		// when we run above line update query will executed.
	}
	
	@Transactional
	public void mergeMethod() {

		Student student = new Student();
		
		student.setId(6);
		student.setName("kantha");
		student.setAddress("amd");
		student.setMobile(712345678);
		
		Student ret = entityManager.merge(student);
		
		ret.setName("kantha s");
		
	}
	
	

}
