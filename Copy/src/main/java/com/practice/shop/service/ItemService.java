package com.practice.shop.service;

import java.util.List;

import com.practice.shop.exception.item.ItemServiceException;
import com.practice.shop.model.Item;

public interface ItemService 
{
	public Item createItem(Item item) throws ItemServiceException;
	public List<Item> getItems() throws ItemServiceException;
}
