package com.practice.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.shop.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>
{

}
