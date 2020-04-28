package com.alfar.demo.customerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alfar.demo.customerModel.APIResponse;
import com.alfar.demo.customerModel.Booking;
import com.alfar.demo.customerModel.Customer;
import com.alfar.demo.customerService.customerService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/customer")
public class customerController {
	
	@Autowired
	customerService customerService;
	
	@PostMapping("/add")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
	
	@GetMapping(value = "/login/{username}/{password}")
	public APIResponse customerLogin(@PathVariable String username, @PathVariable String password) {
		//System.err.println(username + " " + password)
		return customerService.cutomerLogin(username, password);
	}
	
	
	@GetMapping(value = "/getUser/{name}")
	public Customer getCustomer(@PathVariable String name) {
		
		
		return customerService.getCustomer(name);
		
	}
	
	
	@PutMapping(value = "/updateCustomer/{id}")
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable int id) {
		
		return customerService.updateCustomer(customer, id);
		
	}
	
	@GetMapping(value = "/getAllCustomers")
	public List<Customer> getAllcustomers(){
		
		
		return customerService.findAllUsers();
	}
	
	@GetMapping(value = "/getBookingByID/{customerid}")
	public Booking[] findBooking(@PathVariable Integer customerid) {
		
		
		return customerService.findAllBookingByID(customerid);
	}
	
	
	
	@RequestMapping(value = "/insertBooking" , method = RequestMethod.POST)
	public String insertBooing(@RequestBody Booking booking){
		return customerService.insertBooking(booking);
		
		
	}
	
	
	@GetMapping(value = "/findLastRecord/{customerid}")
	public Booking findLastRecord(@PathVariable Integer customerid) {
		
		
		return customerService.findLastRecord(customerid);
	}
}
