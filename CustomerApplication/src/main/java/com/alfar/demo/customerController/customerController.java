package com.alfar.demo.customerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alfar.demo.customerModel.Customer;
import com.alfar.demo.customerService.customerService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin("http://localhost:4200")
public class customerController {
	
	@Autowired
	customerService customerservice;

	
	
	@RequestMapping(value = "/create")
	Customer create(@RequestBody Customer customer) {
		
		
		return customerservice.createCustomer(customer);
		
	}
	
	
}
