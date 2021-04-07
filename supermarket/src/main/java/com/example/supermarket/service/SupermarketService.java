package com.example.supermarket.service;

import com.example.supermarket.model.Item;
import com.example.supermarket.model.Supermarket;
import com.example.supermarket.model.User;

public interface SupermarketService 
{
	public String addItem(Item item);
	public String addSupermarket(Supermarket supermarket);
	public String addUser(User user);
}
