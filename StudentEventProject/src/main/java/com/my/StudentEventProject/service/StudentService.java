package com.my.StudentEventProject.service;

import java.util.List;

import com.my.StudentEventProject.entity.Student;

public interface StudentService {
	
	public List<Student> findAll();

	public Student findById(int theId);

	public void saveOrUpdate(Student theStudent);

	public void deleteById(int theId);


}
