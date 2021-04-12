package com.practice.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.mvc.entity.Student;
import com.practice.mvc.service.StudentService;

@Controller
public class StudentController 
{
	@Autowired
	private StudentService sservice;
	
	@RequestMapping("/")
	public String home(Model m)
	{
		List<Student> students = sservice.getAllStudents();
		m.addAttribute("students",students);
		return "index";
	}
	
	@RequestMapping(value = "/add-student")
	public String addStudent(Model m)
	{
		m.addAttribute("student", new Student());
		return "addStudent";
	}
	
	@RequestMapping("/result")
	public String getStudent(@Valid @ModelAttribute("student") Student student, BindingResult result, HttpServletRequest request, Model m)
	{
		if(result.hasErrors())
		{
//			System.out.println(result.getErrorCount());
			return "addStudent";
//			RedirectView redirectView = new RedirectView();
//			redirectView.setUrl(request.getContextPath() + "/student/add-student");
//			return redirectView;
		}
		
		student = sservice.addStudent(student);
//		RedirectView redirectView = new RedirectView();
//		redirectView.setUrl(request.getContextPath() + "/student/");
//		return redirectView;
		List<Student> students = sservice.getAllStudents();
		m.addAttribute("students",students);
		return "index";
	}
}
