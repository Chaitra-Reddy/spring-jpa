package com.practice.shop.controller;

import java.util.ArrayList;
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

import com.practice.shop.exception.customer.CustomerServiceException;
import com.practice.shop.model.Customer;
import com.practice.shop.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController 
{
	@Autowired
	private CustomerService custService;
	
	@PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) 
    {
		HttpHeaders header = new HttpHeaders();
        try 
        {
			header.add("DESCRIPTION", "Added customer successfully");
			Customer customerOp = custService.createCustomer(customer);
			return ResponseEntity.status(HttpStatus.OK).headers(header).body(customerOp);
		} 
        catch (CustomerServiceException e) 
        {
        	header = new HttpHeaders();
        	header.add("DESCRIPTION", "Adding customer failed");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(header).body(null);
		}
    }
	
	@GetMapping
    public ResponseEntity<List<Customer>> getCustomers() 
	{
		HttpHeaders header = new HttpHeaders();
		List<Customer> customers = new ArrayList<Customer>();
        try 
        {
			header.add("DESCRIPTION", "Getting customers success");
			customers = custService.getCustomers();
			return ResponseEntity.status(HttpStatus.OK).headers(header).body(customers);
		} 
        catch (CustomerServiceException e) 
        {
        	header = new HttpHeaders();
        	header.add("DESCRIPTION", "Getting customers failed");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(header).body(null);
		}
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int id)
	{
		HttpHeaders header = new HttpHeaders();
        try 
        {
			header.add("DESCRIPTION", "Found customer successfully");
			Customer customerOp = custService.getCustomerById(id);
			return ResponseEntity.status(HttpStatus.OK).headers(header).body(customerOp);
		} 
        catch (CustomerServiceException e) 
        {
        	header = new HttpHeaders();
        	header.add("DESCRIPTION", "Finding customer failed");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(null);
		}
	}
	
	@GetMapping("/bill-amount/{id}")
	public ResponseEntity<Double> getBillAmountById(@PathVariable int id)
	{
		HttpHeaders header = new HttpHeaders();
        try 
        {
			header.add("DESCRIPTION", "Found total bill amount successfully");
			double total = custService.getBillAmount(id);
			return ResponseEntity.status(HttpStatus.OK).headers(header).body(total);
		} 
        catch (CustomerServiceException e) 
        {
        	header = new HttpHeaders();
        	header.add("DESCRIPTION", "Failed to find total bill amount");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(-1.0);
		}
	}
}
