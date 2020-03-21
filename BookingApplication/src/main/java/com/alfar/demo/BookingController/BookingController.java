package com.alfar.demo.BookingController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alfar.demo.BookingService.BookingService;
import com.alfar.demo.model.Booking;

@RestController
//@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/Booking")
public class BookingController {
	
	@Autowired
	BookingService bookingservice;
	
	
	@RequestMapping(value = "/insertBooking" ,method = RequestMethod.POST)
	Booking insertBooking(@RequestBody Booking booking) {
		
		
		
		
		return bookingservice.insertBooking(booking);
	
		
	}
	
	
	@RequestMapping(value = "/findAllBookings", method = RequestMethod.GET)
	List<Booking> findBookings(){
		
		return bookingservice.findBookings();
		
	}

}
