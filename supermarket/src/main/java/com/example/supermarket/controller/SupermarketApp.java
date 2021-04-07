package com.example.supermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.supermarket.model.Item;
import com.example.supermarket.model.Supermarket;
import com.example.supermarket.model.User;
import com.example.supermarket.service.SupermarketService;

@RestController
public class SupermarketApp 
{
	@Autowired SupermarketService service;
	
	@PostMapping("/addItem")
	public String addItem(@RequestBody Item item)
	{
		return service.addItem(item);
	}
	
	@PostMapping("/addSupermarket") 
	public String addSupermarket(@RequestBody Supermarket supermarket)
	{
		return service.addSupermarket(supermarket);
	}
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody User user)
	{
		return service.addUser(user);
	}
}
