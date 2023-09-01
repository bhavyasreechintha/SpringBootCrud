package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService service;
	
	@GetMapping("/get")
	public List<Student> getAll()
	{
	return service.getAllStudent();
	}
	
	@PostMapping("/save")
	public String save(@RequestBody Student student)
	{
		
		 service.saveStudent(student);
		 return "data saved successfully";
		
		
	}
	  @GetMapping("/get/{id}")
	    public  ResponseEntity<Student> getStudentById(@PathVariable int id) {
	        return ResponseEntity.ok().body(service.getStudentById(id));
	    }
	  
	  @PutMapping("/{id}")
	    public ResponseEntity < Student > updateProduct(@PathVariable int id, @RequestBody Student stu) {
	        stu.setId(id);
	        return ResponseEntity.ok().body(this.service.updateStudent(id,stu));
	    }
	  @DeleteMapping("/{id}")
	    public String deleteProduct(@PathVariable int id) {
	        this.service.deleteStudent(id);
	        return "data deleted successfully";
	    }
	  
}
