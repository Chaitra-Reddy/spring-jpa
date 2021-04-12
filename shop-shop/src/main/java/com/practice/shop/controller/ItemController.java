package com.practice.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.shop.dto.ItemDto;
import com.practice.shop.exception.contoller_exception.ControllerException;
import com.practice.shop.exception.service_exception.ServiceException;
import com.practice.shop.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController 
{
	@Autowired
	private ItemService itemService;
	
	@PostMapping("/add-item")
	public ResponseEntity<ItemDto> addItem(@RequestBody ItemDto itemDto) throws ControllerException
	{
		try
		{
			itemDto = itemService.createItem(itemDto);
			HttpHeaders header = new HttpHeaders();
			header.add("DESCRIPTION", "Added item successfully");
			return ResponseEntity.status(HttpStatus.OK).headers(header).body(itemDto);
		}
		catch(ServiceException e)
		{
			throw new ControllerException(e.getMessage());
		}
	}
	
	@PostMapping("/add-item/customer/{id}")
	public ResponseEntity<ItemDto> addItem(@RequestBody ItemDto itemDto, @PathVariable int id) throws ControllerException
	{
		try
		{
			itemDto = itemService.createItem(itemDto,id);
			HttpHeaders header = new HttpHeaders();
			header.add("DESCRIPTION", "Added item successfully");
			return ResponseEntity.status(HttpStatus.OK).headers(header).body(itemDto);
		}
		catch(ServiceException e)
		{
			throw new ControllerException(e.getMessage());
		}
	}
}
