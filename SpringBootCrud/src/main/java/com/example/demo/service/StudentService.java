package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Student;

public interface StudentService {

	public List<Student> getAllStudent();

	Student saveStudent(Student student);

	Student getStudentById(int id);



	public Student updateStudent(int id, Student stu);

	public void deleteStudent(int id);

	

}
