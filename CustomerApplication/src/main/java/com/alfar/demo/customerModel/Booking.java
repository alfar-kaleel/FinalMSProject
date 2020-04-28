package com.alfar.demo.customerModel;

import java.sql.Date;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Booking {
	
	
	private Integer id;
	
	private Integer customerid;
	
	private Integer movieid;
	
	
	
	private Date checkin;
	
	private int adults;
	
	private int children;
	
	private String time;
	
	private int total;

	public Booking() {
		
	}

	public Booking(Integer customerid, Integer movieid, Date checkin, int adults, int children,
			String time,int total) {
		
		this.id = id;
		this.customerid = customerid;
		this.movieid = movieid;
		
		
		this.checkin = checkin;
		this.adults = adults;
		this.children = children;
		this.time = time;
		this.total = total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public Integer getMovieid() {
		return movieid;
	}

	public void setMovieid(Integer movieid) {
		this.movieid = movieid;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public int getAdults() {
		return adults;
	}

	public void setAdults(int adults) {
		this.adults = adults;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
	

}
