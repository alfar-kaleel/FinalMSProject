package com.alfar.demo.BookingService;

import java.util.List;

import com.alfar.demo.model.Booking;

public interface BookingService {
	
	
	public Booking insertBooking(Booking booking);
	
	public List<Booking> findBookings();

	
}
