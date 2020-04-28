package com.alfar.demo.customerRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alfar.demo.customerModel.Customer;

public interface customerRepository extends JpaRepository<Customer,Integer>{
	
	Customer findByUsername(String username);
	
	
	
}