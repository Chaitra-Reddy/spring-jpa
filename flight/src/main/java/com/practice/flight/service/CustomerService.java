package com.practice.flight.service;

import java.util.List;

import com.practice.flight.dto.CustomerDto;
import com.practice.flight.exception.service_exceptions.ServiceException;

public interface CustomerService 
{
	public CustomerDto createCustomer(CustomerDto custDto, int flightId) throws ServiceException;
	public List<CustomerDto> getCustomersByFlightName(String flightName) throws ServiceException;
}
