package com.practice.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.mvc.entity.Student;
import com.practice.mvc.repository.StudentRepository;
import com.practice.mvc.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired 
	private StudentRepository srepo;

	@Override
	public Student addStudent(Student student) 
	{
		return srepo.save(student);
	}

	@Override
	public List<Student> getAllStudents() 
	{
		return srepo.findAll();
	}
}
