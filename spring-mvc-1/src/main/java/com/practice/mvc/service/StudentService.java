package com.practice.mvc.service;

import java.util.List;

import com.practice.mvc.entity.Student;

public interface StudentService 
{
	public Student addStudent(Student student);
	public List<Student> getAllStudents();
}
