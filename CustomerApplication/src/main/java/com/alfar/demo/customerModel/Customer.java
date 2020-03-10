package com.alfar.demo.customerModel;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	private int age;
	private String Gender;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	
	@OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)
	private List<Telephone> telephone;
	
	
	public Customer(Integer id, String name, int age, String gender, Address address, List<Telephone> telephone) {
		
		this.id = id;
		this.name = name;
		this.age = age;
		Gender = gender;
		this.address = address;
		this.telephone = telephone;
	}

	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return Gender;
	}


	public void setGender(String gender) {
		Gender = gender;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public List<Telephone> getTelephone() {
		return telephone;
	}


	public void setTelephone(List<Telephone> telephone) {
		this.telephone = telephone;
	}


	

	
	
	
	
	
	

}
