package com.practice.flight.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.practice.flight.dto.CustomerDto;
import com.practice.flight.exception.service_exceptions.DuplicateIDException;
import com.practice.flight.exception.service_exceptions.LimitExceededException;
import com.practice.flight.exception.service_exceptions.NotFoundException;
import com.practice.flight.exception.service_exceptions.ServiceException;
import com.practice.flight.model.Customer;
import com.practice.flight.model.Flight;
import com.practice.flight.repository.CustomerRepository;
import com.practice.flight.repository.FlightRepository;
import com.practice.flight.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService
{
	private static ModelMapper mapper = new ModelMapper();
	
	@Autowired
	private CustomerRepository crepo;
	
	@Autowired
	private FlightRepository frepo;

	@Override
	public CustomerDto createCustomer(CustomerDto custDto, int flightId) throws ServiceException 
	{
		Customer customer = mapper.map(custDto, Customer.class);
		Customer tempCustomer = null;
		try
		{
			Flight flight = frepo.findById(flightId).orElseThrow(() -> new NotFoundException("Flight with ID " + flightId + " not found."));
			int count = (int)crepo.findAll().stream().filter(x -> x.getFlight().getName().equals(flight.getName())).count();
			if(count < flight.getCapacity())
			{
				tempCustomer = crepo.findById(customer.getId()).orElse(null);
				if(tempCustomer == null)
				{
					customer.setFlight(flight);
					tempCustomer = crepo.save(customer);
					return (mapper.map(tempCustomer, CustomerDto.class));
				}
				else
				{
					throw new DuplicateIDException("Duplicate ID not allowed.");
				}
			}
			else
			{
				throw new LimitExceededException("Maximum capacity reached!.");
			}
		}
		catch(NotFoundException e)
		{
			throw new ServiceException(e.getMessage());
		}
		catch(LimitExceededException e)
		{
			throw new ServiceException(e.getMessage());
		}
		catch(DataAccessException e)
		{
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public List<CustomerDto> getCustomersByFlightName(String flightName) throws ServiceException 
	{
		List<Customer> customers = new ArrayList<>();
		List<CustomerDto> customersDto = new ArrayList<>();
		try
		{
			customers = crepo.findCustomersByFlightName(flightName);
			if(customers.size() <= 0)
			{
				throw new NotFoundException("No customer found in " + flightName + ".");
			}
			customersDto = customers.stream().map(x -> mapper.map(x, CustomerDto.class)).collect(Collectors.toList());
			return customersDto;
		}
		catch(NotFoundException e)
		{
			throw new ServiceException(e.getMessage());
		}
		catch(DataAccessException e)
		{
			throw new ServiceException(e.getMessage());
		}
	}

}
