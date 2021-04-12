package com.practice.flight.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.flight.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
	@Query("select c from Customer c where c.flight.name = ?1")
	List<Customer> findCustomersByFlightName(String flightName);
}
