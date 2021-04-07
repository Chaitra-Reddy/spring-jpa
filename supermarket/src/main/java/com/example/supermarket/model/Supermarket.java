package com.example.supermarket.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Supermarket 
{
	@Id
	private int id;
	
	@OneToMany(mappedBy="supermarket", cascade = CascadeType.ALL)
	private List<User> users;
	
	@OneToMany(mappedBy="supermarket", cascade = CascadeType.ALL)
	private List<Item> items;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}
