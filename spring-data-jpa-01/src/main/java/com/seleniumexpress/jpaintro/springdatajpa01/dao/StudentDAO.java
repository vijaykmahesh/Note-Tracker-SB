package com.seleniumexpress.jpaintro.springdatajpa01.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.seleniumexpress.jpaintro.springdatajpa01.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAO {

	@Autowired
	EntityManager entityManager; // session

	@Transactional
	public void save(Student student) {

		// giving transient state to persistence state
		entityManager.persist(student);
		System.out.println("student record saved..");

	}// commit

	// entity manager will be closed automatically

	public Student findById(int id) {

		Student student = null;

		student = entityManager.find(Student.class, id);

		return student;

	}

	public List<Student> findAllStudent() {

		List<Student> studentList = null;

		TypedQuery<Student> query = entityManager.createQuery("from Student", Student.class);

		studentList = query.getResultList();

		return studentList;

	}

	public List<Student> findAllStudentWithFirstName(String theName) {

		List<Student> studentList = null;

		TypedQuery<Student> query = entityManager.createQuery("from Student where studentName=:name ", Student.class);
		query.setParameter("name", theName);

		studentList = query.getResultList();

		return studentList;

	}

	@Transactional
	public void test() {

		Student student = new Student();

		student.setStudentName("Abhipsa");
		student.setMobile(777777);
		student.setAddr("odisha");

		Student retStudent = entityManager.merge(student); // insert

		retStudent.setStudentName("Abhipsa P");

		System.out.println(">>>>>>>>>>>" + student.hashCode());
		System.out.println(">>>>>>>>>>>" + retStudent.hashCode());

	}

}
