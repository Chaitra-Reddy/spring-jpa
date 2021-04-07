package com.practice.shop.service;

import java.util.List;

import com.practice.shop.exception.customer.CustomerServiceException;
import com.practice.shop.model.Customer;

public interface CustomerService 
{
	public Customer createCustomer(Customer customer) throws CustomerServiceException;
	public List<Customer> getCustomers() throws CustomerServiceException;
	public Customer getCustomerById(int id) throws CustomerServiceException;
	public double getBillAmount(int id) throws CustomerServiceException;
}
