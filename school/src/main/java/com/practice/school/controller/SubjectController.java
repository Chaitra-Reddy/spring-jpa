package com.practice.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.school.model.Student;
import com.practice.school.model.Subject;
import com.practice.school.model.Teacher;
import com.practice.school.repository.StudentRepository;
import com.practice.school.repository.SubjectRepository;
import com.practice.school.repository.TeacherRepository;

@RestController
@RequestMapping("/subjects")
public class SubjectController 
{
	@Autowired 
	private SubjectRepository subjectRepo;
	
	@Autowired 
	private StudentRepository studentRepo;
	
	@Autowired 
	private TeacherRepository teacherRepo;
	
	@GetMapping
	public List<Subject> getSubjects() 
	{
        return subjectRepo.findAll();
    }
	
	@PostMapping
    Subject createSubject(@RequestBody Subject subject) 
	{
        return subjectRepo.save(subject);
    }
	
	@PutMapping("/{subjectId}/students/{studentId}")
    Subject addStudentToSubject(
            @PathVariable Long subjectId,
            @PathVariable Long studentId
    ) {
        Subject subject = subjectRepo.findById(subjectId).get();
        Student student = studentRepo.findById(studentId).get();
        subject.enrollStudent(student);
        return subjectRepo.save(subject);
    }
	
	@PutMapping("/{subjectId}/teacher/{teacherId}")
    Subject assignTeacherToSubject(
            @PathVariable Long subjectId,
            @PathVariable Long teacherId
    ) {
        Subject subject = subjectRepo.findById(subjectId).get();
        Teacher teacher = teacherRepo.findById(teacherId).get();
        subject.setTeacher(teacher);
        return subjectRepo.save(subject);
    }
}
