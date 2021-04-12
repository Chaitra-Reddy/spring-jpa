package com.practice.shop.dto;

import java.util.List;

import com.practice.shop.model.Customer;

import lombok.Data;

@Data
public class ItemDto 
{
	private int id;
	private String name;
	private double price;
	private List<Customer> customers;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
}
