package com.example.supermarket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supermarket.model.Item;
import com.example.supermarket.model.Supermarket;
import com.example.supermarket.model.User;
import com.example.supermarket.repository.ItemRepository;
import com.example.supermarket.repository.SupermarketRepository;
import com.example.supermarket.repository.UserRepository;
import com.example.supermarket.service.SupermarketService;

@Service
public class SupermarketServiceImpl implements SupermarketService
{
	@Autowired private ItemRepository itemRepo;
	@Autowired private SupermarketRepository superRepo;
	@Autowired private UserRepository userRepo;

	@Override
	public String addItem(Item item) 
	{
		itemRepo.save(item);
		return "Successfully added item.";
	}

	@Override
	public String addSupermarket(Supermarket supermarket) 
	{
		List<Item> items = supermarket.getItems();
		for(Item i:items)
		{
			i.getSupermarket().setId(supermarket.getId());
		}
		List<User> users = supermarket.getUsers();
		for(User u:users)
		{
			u.getSupermarket().setId(supermarket.getId());
		}
		superRepo.save(supermarket);
		return "Successfully added supermarket.";
	}

	@Override
	public String addUser(User user) 
	{
		userRepo.save(user);
		return "Successfully added user.";
	}

}
