package com.alfar.demo.BookingRepository;

import java.util.List;

import org.aspectj.weaver.tools.Trace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alfar.demo.model.Booking;

public interface BookingRepository extends JpaRepository<Booking,Integer>{
	
	@Query(value = "SELECT * FROM booking b WHERE b.customerid = ?1",nativeQuery = true)
	List<Booking> findAllByid(Integer id);

	
	@Query(value = "SELECT * FROM booking WHERE customerid = ?1 ORDER BY id DESC LIMIT 1",nativeQuery = true)
	Booking findLastRecord(Integer customerid);
	//Booking findTopByOrderByIdDesc();

}
