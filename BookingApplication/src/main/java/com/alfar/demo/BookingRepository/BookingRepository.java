package com.alfar.demo.BookingRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alfar.demo.model.Booking;

public interface BookingRepository extends JpaRepository<Booking,Integer>{
	
	

}
