package com.practice.shop.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.shop.exception.customer.CustomerNotFoundException;
import com.practice.shop.exception.customer.CustomerServiceException;
import com.practice.shop.exception.item.ItemNotFoundException;
import com.practice.shop.model.Customer;
import com.practice.shop.model.Item;
import com.practice.shop.repository.CustomerRepository;
import com.practice.shop.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService 
{
	@Autowired
	private CustomerRepository custRepo;

	@Override
	public Customer createCustomer(Customer customer) throws CustomerServiceException 
	{
		try
		{
			return custRepo.save(customer);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new CustomerServiceException("Somethimg went wrong while adding customer to DB.",e);
		}
	}

	@Override
	public List<Customer> getCustomers() throws CustomerServiceException 
	{
		List<Customer> customers = new ArrayList<Customer>();
		try
		{
			customers = custRepo.findAll();
			if(customers.size() <= 0)
			{
				throw new CustomerNotFoundException();
			}
			return customers;
		}
		catch(CustomerNotFoundException e)
		{
			e.printStackTrace();
			throw new CustomerServiceException("No customers found.",e);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new CustomerServiceException("Somethimg went wrong while getting customers from DB.",e);
		}
	}

	@Override
	public Customer getCustomerById(int id) throws CustomerServiceException 
	{
		try
		{
			Customer customer = custRepo.findById(id).orElseThrow(() -> new CustomerNotFoundException());
			return customer;
		}
		catch(CustomerNotFoundException e)
		{
			e.printStackTrace();
			throw new CustomerServiceException("No customer found.",e);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new CustomerServiceException("Somethimg went wrong while getting customer from DB.",e);
		}
	}

	@Override
	public double getBillAmount(int id) throws CustomerServiceException 
	{
		double sum = 0;
		Set<Item> items = new HashSet<Item>();
		try
		{
			Customer customer = custRepo.findById(id).orElseThrow(() -> new CustomerNotFoundException());
			items = customer.getItems();
			if(items.size() <= 0)
			{
				throw new ItemNotFoundException();
			}
			sum = items.stream().map(x -> x.getPrice()).reduce(0.0, Double::sum);
			return sum;
		}
		catch(CustomerNotFoundException e)
		{
			e.printStackTrace();
			throw new CustomerServiceException("No customer found.",e);
		}
		catch(ItemNotFoundException e)
		{
			e.printStackTrace();
			throw new CustomerServiceException("No items found.",e);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new CustomerServiceException("Somethimg went wrong while getting customer from DB.",e);
		}
	}
	
}
