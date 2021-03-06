package com.practice.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.shop.exception.item.ItemServiceException;
import com.practice.shop.model.Item;
import com.practice.shop.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController 
{
	@Autowired
	private ItemService itemService;
	
	@PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) 
    {
		HttpHeaders header = new HttpHeaders();
        try 
        {
			header.add("DESCRIPTION", "Added item successfully");
			Item itemOp = itemService.createItem(item);
			return ResponseEntity.status(HttpStatus.OK).headers(header).body(itemOp);
		} 
        catch (ItemServiceException e) 
        {
        	header = new HttpHeaders();
        	header.add("DESCRIPTION", "Adding item failed");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(header).body(null);
		}
    }
	
	@GetMapping
    public ResponseEntity<List<Item>> getItems() 
	{
		HttpHeaders header = new HttpHeaders();
		List<Item> items = new ArrayList<Item>();
        try 
        {
			header.add("DESCRIPTION", "Getting items success");
			items = itemService.getItems();
			return ResponseEntity.status(HttpStatus.OK).headers(header).body(items);
		} 
        catch (ItemServiceException e) 
        {
        	header = new HttpHeaders();
        	header.add("DESCRIPTION", "Getting items failed");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(header).body(null);
		}
    }
}
