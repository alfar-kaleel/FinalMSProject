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
	private String gender;
	private String email;
	private String password;
	
	
	
	

	


	@OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)
	private List<Telephone> telephone;
	
	
	public Customer(Integer id, String name, int age, String gender,String email,String password, List<Telephone> telephone) {
		
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.password = password;
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

	
	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		gender = gender;
	}


	

	public List<Telephone> getTelephone() {
		return telephone;
	}


	public void setTelephone(List<Telephone> telephone) {
		this.telephone = telephone;
	}


	

	
	
	
	
	
	

}
