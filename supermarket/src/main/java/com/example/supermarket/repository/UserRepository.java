package com.example.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.supermarket.model.User;

public interface UserRepository extends JpaRepository<User, Integer> 
{

}
