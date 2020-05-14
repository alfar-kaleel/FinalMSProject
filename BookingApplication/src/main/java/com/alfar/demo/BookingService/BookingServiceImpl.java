package com.alfar.demo.BookingService;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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

	@Override
	public List<Booking> findBookingById(Integer id) {
		//Booking booking = new Booking();
		
		//booking.setCustomerid(id);
		
		//System.out.print(booking.getCustomerid()+" "+booking);
		
        //Example<Booking> exampleBooking = Example.of(booking);
        
		return BookingRepo.findAllByid(id);
	}

	@Override
	public Booking findLastRecord(Integer customerid) {
		
		return BookingRepo.findLastRecord(customerid);
	}

}
