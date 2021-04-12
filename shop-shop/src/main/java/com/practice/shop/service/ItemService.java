package com.practice.shop.service;

import com.practice.shop.dto.ItemDto;
import com.practice.shop.exception.service_exception.ServiceException;

public interface ItemService 
{
	public ItemDto createItem(ItemDto itemDto) throws ServiceException;
	public ItemDto createItem(ItemDto itemDto, int customerId) throws ServiceException;
}
