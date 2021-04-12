package com.practice.shop.dto;

import java.util.List;

import com.practice.shop.model.Item;

import lombok.Data;

@Data
public class CustomerDto 
{
	private int id;
	private String name;
	private List<Item> items;
	
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
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
}
