
  package com.my.StudentEventProject.repository;
  

import com.my.StudentEventProject.entity.Student;
  
  import org.springframework.data.jpa.repository.JpaRepository;
  
  public interface StudentRepository extends JpaRepository<Student,Integer> {
  
	  
  }
 