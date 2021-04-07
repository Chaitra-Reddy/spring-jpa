package com.example.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.supermarket.model.Supermarket;

public interface SupermarketRepository extends JpaRepository<Supermarket, Integer>
{

}
