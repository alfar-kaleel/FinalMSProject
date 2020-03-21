package com.alfar.demo.customerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alfar.demo.customerModel.Customer;
import com.alfar.demo.customerRepository.customerRepository;

@Service
public class customerServiceImpl implements customerService {
	
	@Autowired
	customerRepository customerRepo;

	@Override
	public Customer createCustomer(Customer customer) {
		
		return customerRepo.save(customer);
	}
	
	
	

}
