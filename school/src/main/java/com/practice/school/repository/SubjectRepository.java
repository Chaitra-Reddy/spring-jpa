package com.practice.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.school.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> 
{

}
