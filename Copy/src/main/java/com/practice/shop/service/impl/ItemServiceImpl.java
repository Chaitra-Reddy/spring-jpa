package com.practice.shop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.shop.exception.item.ItemNotFoundException;
import com.practice.shop.exception.item.ItemServiceException;
import com.practice.shop.model.Item;
import com.practice.shop.repository.ItemRepository;
import com.practice.shop.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService
{
	@Autowired
	private ItemRepository itemRepo;

	@Override
	public Item createItem(Item item) throws ItemServiceException 
	{
		try
		{
			return itemRepo.save(item);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new ItemServiceException("Somethimg went wrong while adding item to DB.",e);
		}
	}

	@Override
	public List<Item> getItems() throws ItemServiceException 
	{
		List<Item> items = new ArrayList<Item>();
		try
		{
			items = itemRepo.findAll();
			if(items.size() <= 0)
			{
				throw new ItemNotFoundException();
			}
			return items;
		}
		catch(ItemNotFoundException e)
		{
			e.printStackTrace();
			throw new ItemServiceException("No items found.",e);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new ItemServiceException("Somethimg went wrong while getting items from DB.",e);
		}
	}
	
}
