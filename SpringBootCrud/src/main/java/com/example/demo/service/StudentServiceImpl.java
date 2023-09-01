package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepo;
import com.example.demo.service.exception.ResourceNotFoundException;


@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepo repo;

	@Override
	public List<Student> getAllStudent() {
		
		return repo.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		
		 return repo.save(student);
	}

	@Override
	public Student getStudentById(int id) {
		Optional<Student>  stu = this.repo.findById(id);
		 if (stu.isPresent()) {
	            return stu.get();
	        } else {
	            throw new ResourceNotFoundException("Record not found with id : " + id);
	        }
	}
	
	@Override
    public Student updateStudent(int id,Student stu) {
        Optional < Student > stud= this.repo.findById(stu.getId());

        if (stud.isPresent()) {
        	stu.setId(id);
            return repo.save(stu);
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + stu.getId());
        }
	
	}

	@Override
	public void deleteStudent(int id) {
		  Optional < Student > stu = this.repo.findById(id);

	        if (stu.isPresent()) {
	            this.repo.delete(stu.get());
	        } else {
	            throw new ResourceNotFoundException("Record not found with id : " + id);
	        }
		
	}}

