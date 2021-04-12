package com.practice.flight.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.flight.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer>
{
	@Query("select f from Flight f where f.source = ?1 and f.dest = ?2")
	List<Flight> getFlights(String src, String dest);
}
