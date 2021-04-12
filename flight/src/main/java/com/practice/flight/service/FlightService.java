package com.practice.flight.service;

import java.util.List;

import com.practice.flight.dto.FlightDto;
import com.practice.flight.exception.service_exceptions.ServiceException;

public interface FlightService 
{
	public FlightDto createFlight(FlightDto flightDto) throws ServiceException;
	public List<FlightDto> getFlightsBasedOnSrcAndDest(String src, String dest) throws ServiceException;
}
