package com.practice.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.flight.dto.CustomerDto;
import com.practice.flight.exception.controller_exceptions.ControllerException;
import com.practice.flight.exception.service_exceptions.ServiceException;
import com.practice.flight.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController 
{
	@Autowired
	private CustomerService cservice;
	
	@PostMapping("/add-customer/flight/{id}")
	public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto custDto, @PathVariable int id) throws ControllerException
	{
		try
		{
			custDto = cservice.createCustomer(custDto, id);
			HttpHeaders header = new HttpHeaders();
			header.add("DESCRIPTION", "Added customer successfully");
			return ResponseEntity.status(HttpStatus.OK).headers(header).body(custDto);
		}
		catch(ServiceException e)
		{
			throw new ControllerException(e.getMessage());
		}
	}
	
	@GetMapping("/getAll/{flightName}")
	public ResponseEntity<List<CustomerDto>> getCustomersByFlightName(@PathVariable String flightName) throws ControllerException
	{
		try
		{
			List<CustomerDto> customersDto = cservice.getCustomersByFlightName(flightName);
			HttpHeaders header = new HttpHeaders();
			header.add("DESCRIPTION", "Fetched customers based on flight name successfully");
			return ResponseEntity.status(HttpStatus.OK).headers(header).body(customersDto);
		}
		catch(ServiceException e)
		{
			throw new ControllerException(e.getMessage());
		}
	}
}
