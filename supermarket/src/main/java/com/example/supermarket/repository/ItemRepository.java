package com.example.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.supermarket.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>
{

}
