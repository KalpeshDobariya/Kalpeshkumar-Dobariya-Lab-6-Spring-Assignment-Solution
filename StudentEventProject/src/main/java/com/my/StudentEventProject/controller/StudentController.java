package com.my.StudentEventProject.controller;


import java.security.Principal;
import java.util.List;
import com.my.StudentEventProject.entity.Student;
import com.my.StudentEventProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	public StudentService studentService;
	
	
	  @RequestMapping("/list") 
	  public String liststudents(Model theModel) {
	     List<Student> theStudents = studentService.findAll();
	     theModel.addAttribute("Students",theStudents); 
	     return "list-students";}
	 
		
		@RequestMapping("/showFormForAdd")
		public String showFormForAdd(Model theModel) {
			Student theStudent = new Student();
			theModel.addAttribute("Student", theStudent);
			return "Student-form";}
	
		
	    @RequestMapping("/showFormForUpdate")
	    public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {
	  	Student theStudent = studentService.findById(theId);
		theModel.addAttribute("Student", theStudent);
		return "Student-form";}
	
		
	    @PostMapping("/save")
	    public String saveOrUpdate(@RequestParam("id") int id,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("country") String country, 
			@RequestParam("course") String course) {
		Student theStudent;
		if (id != 0) {
			theStudent =studentService.findById(id);
			theStudent.setFirstName(firstName);
			theStudent.setLastName(lastName);
			theStudent.setCourse(course);
			theStudent.setCountry(country);
			}
		else {
			theStudent = new Student();
		    theStudent.setFirstName(firstName);
		    theStudent.setLastName(lastName);
		    theStudent.setCourse(course);
		    theStudent.setCountry(country);}
		    studentService.saveOrUpdate(theStudent);
		    return "redirect:/students/list";}
	  
	

	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int theId) {
		studentService.deleteById(theId);
		return "redirect:/students/list";}
	
	
	
	@RequestMapping(value="/403")
	public ModelAndView accessDenied (Principal user) {
		ModelAndView model= new ModelAndView ();
		if(user !=null) {
			model.addObject("msg", "Hi" +user.getName()+"you do not have permission to access this page!");}
		else {
			model.addObject("msg","you do not have permission to access this page!");
		}
		model.setViewName("403");
		return model;
				
	}
	

}
