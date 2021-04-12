package com.practice.shop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.practice.shop.dto.ItemDto;
import com.practice.shop.exception.service_exception.CustomerNotFoundException;
import com.practice.shop.exception.service_exception.DuplicateIDException;
import com.practice.shop.exception.service_exception.ServiceException;
import com.practice.shop.model.Customer;
import com.practice.shop.model.Item;
import com.practice.shop.repository.CustomerRepository;
import com.practice.shop.repository.ItemRepository;
import com.practice.shop.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService
{
	private static ModelMapper mapper = new ModelMapper();
	
	@Autowired
	private ItemRepository itemRepo;
	
	@Autowired
	private CustomerRepository custRepo;

	@Override
	public ItemDto createItem(ItemDto itemDto) throws ServiceException 
	{
		Item item = mapper.map(itemDto, Item.class);
		Item tempItem = null;
		
		try
		{
			tempItem = itemRepo.findById(item.getId()).orElse(null);
			if(tempItem == null)
			{
				List<Customer> customers = item.getCustomers();
				for(Customer c:customers)
				{
					custRepo.findById(c.getId()).orElseThrow(
							() -> new CustomerNotFoundException("Customer with ID " + c.getId() + " not found.")
							);
				}
				item = itemRepo.save(item);
				return (mapper.map(item, ItemDto.class));
			}
			else
			{
				throw new DuplicateIDException("Error! Duplicate ID not allowed.");
			}
		}
		catch(CustomerNotFoundException e)
		{
			throw new ServiceException(e.getMessage());
		}
		catch(DuplicateIDException e)
		{
			throw new ServiceException(e.getMessage());
		}
		catch(DataAccessException e)
		{
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public ItemDto createItem(ItemDto itemDto, int customerId) throws ServiceException 
	{
		Item item = mapper.map(itemDto, Item.class);
		List<Customer> custList = new ArrayList<>();
		Item tempItem = null;
		try
		{
			tempItem = itemRepo.findById(item.getId()).orElse(null);
			if(tempItem == null)
			{
				Customer customer = custRepo.findById(customerId).orElseThrow(
						() -> new CustomerNotFoundException("Customer with ID " + customerId + " not found.")
						);
				custList.add(customer);
				item.setCustomers(custList);
				itemRepo.save(item);
				return (mapper.map(item, ItemDto.class));
			}
			else
			{
				throw new DuplicateIDException("Error! Duplicate ID not allowed.");
			}
		}
		catch(CustomerNotFoundException e)
		{
			throw new ServiceException(e.getMessage());
		}
		catch(DuplicateIDException e)
		{
			throw new ServiceException(e.getMessage());
		}
		catch(DataAccessException e)
		{
			throw new ServiceException(e.getMessage());
		}
	}
	
}
