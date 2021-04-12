package com.practice.flight.controller;

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

import com.practice.flight.dto.FlightDto;
import com.practice.flight.exception.controller_exceptions.ControllerException;
import com.practice.flight.exception.service_exceptions.ServiceException;
import com.practice.flight.service.FlightService;

@RestController
@RequestMapping("/flight")
public class FlightController 
{
	@Autowired
	private FlightService fservice;
	
	@PostMapping("/add-flight")
	public ResponseEntity<FlightDto> addFlight(@RequestBody FlightDto flightDto) throws ControllerException
	{
		try
		{
			flightDto = fservice.createFlight(flightDto);
			HttpHeaders header = new HttpHeaders();
			header.add("DESCRIPTION", "Added flight successfully");
			return ResponseEntity.status(HttpStatus.OK).headers(header).body(flightDto);
		}
		catch(ServiceException e)
		{
			throw new ControllerException(e.getMessage());
		}
	}
	
	@GetMapping("/getFlights/{src}-{dest}")
	public ResponseEntity<List<FlightDto>> getFlightsBasedOnSrcDest(@PathVariable String src, @PathVariable String dest) throws ControllerException
	{
		List<FlightDto> flightDtos = new ArrayList<>();
		try
		{
			flightDtos = fservice.getFlightsBasedOnSrcAndDest(src, dest);
			HttpHeaders header = new HttpHeaders();
			header.add("DESCRIPTION", "Fetched flights successfully");
			return ResponseEntity.status(HttpStatus.OK).headers(header).body(flightDtos);
		}
		catch(ServiceException e)
		{
			throw new ControllerException(e.getMessage());
		}
	}
	
}
