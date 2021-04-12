package com.practice.shop.controller;

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

import com.practice.shop.dto.CustomerDto;
import com.practice.shop.exception.contoller_exception.ControllerException;
import com.practice.shop.exception.service_exception.ServiceException;
import com.practice.shop.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController 
{
	@Autowired
	private CustomerService custService;
	
	@PostMapping("/add-customer")
	public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto customerDto) throws ControllerException
	{
		try
		{
			customerDto = custService.createCustomer(customerDto);
			HttpHeaders header = new HttpHeaders();
			header.add("DESCRIPTION", "Added customer successfully");
			return ResponseEntity.status(HttpStatus.OK).headers(header).body(customerDto);
		}
		catch(ServiceException e)
		{
			throw new ControllerException(e.getMessage());
		}
	}
	
	@GetMapping("/get-bill/{id}")
	public ResponseEntity<Double> getBillAmount(@PathVariable int id) throws ControllerException
	{
		try
		{
			double sum = custService.getBillAmount(id);
			HttpHeaders header = new HttpHeaders();
			header.add("DESCRIPTION", "Calculated bill amount successfully");
			return ResponseEntity.status(HttpStatus.OK).headers(header).body(sum);
		}
		catch(ServiceException e)
		{
			throw new ControllerException(e.getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDto> getcustomerById(@PathVariable int id) throws ControllerException
	{
		try
		{
			CustomerDto customerDto = custService.getCustomerById(id);
			HttpHeaders header = new HttpHeaders();
			header.add("DESCRIPTION", "Getting customer by ID success");
			return ResponseEntity.status(HttpStatus.OK).headers(header).body(customerDto);
		}
		catch(ServiceException e)
		{
			throw new ControllerException(e.getMessage());
		}
	}
}
