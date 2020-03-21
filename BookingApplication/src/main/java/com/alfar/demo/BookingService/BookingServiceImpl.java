package com.alfar.demo.BookingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alfar.demo.BookingRepository.BookingRepository;
import com.alfar.demo.model.Booking;

@Service
public class BookingServiceImpl implements BookingService{
	
	
	@Autowired
	BookingRepository BookingRepo;

	@Override
	public Booking insertBooking(Booking booking) {
		
		return BookingRepo.save(booking);
	}

	@Override
	public List<Booking> findBookings() {
		
		return BookingRepo.findAll();
	}

}
