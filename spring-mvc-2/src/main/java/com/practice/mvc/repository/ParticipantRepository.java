package com.practice.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.mvc.entity.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Integer>
{
	
}
