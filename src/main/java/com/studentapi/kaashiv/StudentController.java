package com.studentapi.kaashiv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class StudentController {
	
	@Autowired
	Student_Repo repo;
	
	@GetMapping("/")
	public List<Student_model> GetAll(){
		List<Student_model> list= repo.all_student();
		return list;
	}
	
	@GetMapping("/get/{id}")
	public Student_model oneStudent(@PathVariable int id) {
	
	 
	return	repo.OneStudent(id);
		
	}
	
	@PostMapping("/post")
	public void insert_students(@RequestBody Student_model std ) {
		
		repo.sp_insert_student(std.getEmail(), std.getPassword(), std.getName(), std.getcourse(), std.getFees());
	}
	
	@PutMapping("/put/{id}")
	
	public void Update_students(   @PathVariable int id, @RequestBody Student_model std ) {
		repo.update_student(id, std.getPassword(), std.getName(), std.getcourse(), std.getFees());
	}
	
	 @DeleteMapping("/delete/{id}")
		public void  StudentDelete(@PathVariable int id) {
		
		 
		 repo.sp_student_del(id);
			
		}

}
