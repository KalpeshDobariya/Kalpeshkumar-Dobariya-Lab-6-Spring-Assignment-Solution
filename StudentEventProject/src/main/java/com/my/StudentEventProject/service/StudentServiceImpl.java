package com.my.StudentEventProject.service;

import java.util.List;

import com.my.StudentEventProject.entity.Student;
import com.my.StudentEventProject.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;




@Service
public class StudentServiceImpl implements StudentService{
		
		@Autowired 
		StudentRepository studentRepository;
		
			
			//Print All Record
		 
			@Override
			 public List<Student> findAll() {
				List<Student> students = studentRepository.findAll();
				return students; }
			
			
			//Find Record by Id
			@Override
			 public Student findById(int id) {
				Student student = studentRepository.findById(id).get();
				return student;}		 
			 
			 
			//Save or Insert customer Record
			 @Override
			 public void saveOrUpdate(Student theStudent) {
				 studentRepository.save(theStudent);}
				 
		

			//Delete customer Record 			
			 @Override
			 public void deleteById(int id) {
				 studentRepository.deleteById(id);}
			   	
			
	}

