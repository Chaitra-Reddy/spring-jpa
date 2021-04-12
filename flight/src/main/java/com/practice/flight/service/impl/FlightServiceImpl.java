package com.practice.flight.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.practice.flight.dto.FlightDto;
import com.practice.flight.exception.service_exceptions.DuplicateIDException;
import com.practice.flight.exception.service_exceptions.NotFoundException;
import com.practice.flight.exception.service_exceptions.ServiceException;
import com.practice.flight.model.Flight;
import com.practice.flight.repository.FlightRepository;
import com.practice.flight.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService
{
	private static ModelMapper mapper = new ModelMapper();
	
	@Autowired
	private FlightRepository frepo;

	@Override
	public FlightDto createFlight(FlightDto flightDto) throws ServiceException 
	{
		Flight flight = mapper.map(flightDto, Flight.class);
		Flight tempFlight = null;
		try
		{
			tempFlight = frepo.findById(flight.getId()).orElse(null);
			if(tempFlight == null)
			{
				tempFlight = frepo.save(flight);
				return (mapper.map(tempFlight, FlightDto.class));
			}
			else
			{
				throw new DuplicateIDException("Duplicate ID not allowed.");
			}
		}
		catch(DuplicateIDException e)
		{
			throw new ServiceException(e.getMessage());
		}
		catch(DataAccessException e)
		{
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public List<FlightDto> getFlightsBasedOnSrcAndDest(String src, String dest) throws ServiceException 
	{
		try
		{
			List<Flight> flights = frepo.getFlights(src, dest);
			if(flights.size() <= 0)
			{
				throw new NotFoundException("No flights found between " + src + " and " + dest + ".");
			}
			
			List<FlightDto> flightDtos = flights.stream().map(x -> mapper.map(x, FlightDto.class)).collect(Collectors.toList());
			return flightDtos;
		}
		catch(NotFoundException e)
		{
			throw new ServiceException(e.getMessage());
		}
		catch(DataAccessException e)
		{
			throw new ServiceException(e.getMessage());
		}
	}

}
