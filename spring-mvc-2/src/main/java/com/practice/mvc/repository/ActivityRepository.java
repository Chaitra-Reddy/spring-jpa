package com.practice.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.mvc.entity.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Integer>
{
	Activity findByName(String name);
}
