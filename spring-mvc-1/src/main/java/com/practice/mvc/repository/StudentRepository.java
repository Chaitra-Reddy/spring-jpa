package com.practice.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.mvc.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
{

}
