package com.alfar.demo.customerService;

import java.util.List;

import com.alfar.demo.customerModel.APIResponse;
import com.alfar.demo.customerModel.Booking;
import com.alfar.demo.customerModel.Customer;

public interface customerService {

	
	Customer addCustomer(Customer customer);
	
	String insertBooking(Booking booking);
	
	APIResponse cutomerLogin(String username, String password);
	
	Customer updateCustomer(Customer user,int id);
	
	
	Customer getCustomer(String customer);
	
	List<Customer> findAllUsers();
	
	Booking[] findAllBookingByID(Integer customerid); 
	
	Booking findLastRecord(Integer customerid);
}
