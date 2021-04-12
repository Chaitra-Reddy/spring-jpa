package com.practice.shop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.practice.shop.dto.CustomerDto;
import com.practice.shop.exception.service_exception.CustomerNotFoundException;
import com.practice.shop.exception.service_exception.DuplicateIDException;
import com.practice.shop.exception.service_exception.ServiceException;
import com.practice.shop.model.Customer;
import com.practice.shop.model.Item;
import com.practice.shop.repository.CustomerRepository;
import com.practice.shop.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService
{
	private static ModelMapper mapper = new ModelMapper();
	
	@Autowired
	private CustomerRepository custRepo;

	@Override
	public CustomerDto createCustomer(CustomerDto customerDto) throws ServiceException 
	{
		Customer customer = mapper.map(customerDto, Customer.class);
		Customer tempCustomer = null;
		
		try
		{
			tempCustomer = custRepo.findById(customer.getId()).orElse(null);
			if(tempCustomer == null)
			{
				tempCustomer = custRepo.save(customer);
				return (mapper.map(tempCustomer, CustomerDto.class));
			}
			else
			{
				throw new DuplicateIDException("Error! Duplicate ID not allowed.");
			}
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
	public double getBillAmount(int customerId) throws ServiceException 
	{
		double sum = 0;
		List<Item> items = new ArrayList<Item>();
		try
		{
			Customer customer = custRepo.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Error! Customer with ID " + customerId + " not found."));
			items = customer.getItems();
			sum = items.stream().map(x -> x.getPrice()).reduce(0.0, Double::sum);
			return sum;
		}
		catch(CustomerNotFoundException e)
		{
			throw new ServiceException(e.getMessage());
		}
		catch(DataAccessException e)
		{
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public CustomerDto getCustomerById(int id) throws ServiceException 
	{
		try
		{
			Customer customer = custRepo.findById(id).orElseThrow(() -> new CustomerNotFoundException("Error! Customer with ID " + id + " not found."));
			return (mapper.map(customer, CustomerDto.class));
		}
		catch(CustomerNotFoundException e)
		{
			throw new ServiceException(e.getMessage());
		}
		catch(DataAccessException e)
		{
			throw new ServiceException(e.getMessage());
		}
	}

}
