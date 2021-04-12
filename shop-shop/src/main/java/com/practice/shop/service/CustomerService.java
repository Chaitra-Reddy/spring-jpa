package com.practice.shop.service;

import com.practice.shop.dto.CustomerDto;
import com.practice.shop.exception.service_exception.ServiceException;

public interface CustomerService 
{
	public CustomerDto createCustomer(CustomerDto customerDto) throws ServiceException;
	public double getBillAmount(int customerId) throws ServiceException;
	public CustomerDto getCustomerById(int id) throws ServiceException;
}
