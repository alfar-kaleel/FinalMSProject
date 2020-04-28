package com.alfar.spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;






@Entity
@Table(name = "user")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	


	private String username;
	private String password;
	private String email;
	
	private int age;
	

	private String Gender;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	
	@OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
	private List<Telephone> telephone;
	
	private boolean enabled;
	private boolean accountNonExpired;
	private boolean credentialsNonExpired;
	private boolean accountNonLocked;
	
	public User() {}
	
	public User(User user) {
		
		
		this.username = user.username;
		this.password = user.password;
		this.email = user.email;
		this.age = user.age;
		this.Gender = user.Gender;
		this.address = user.address;
		this.enabled = user.enabled;
		this.accountNonExpired = user.accountNonExpired;
		this.credentialsNonExpired = user.credentialsNonExpired;
		this.accountNonLocked = user.accountNonLocked;
		this.roles = user.roles;
	}
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name= "role_user",joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "id")})
	private List<Role> roles;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonIgnore
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@JsonIgnore
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	@JsonIgnore
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonBlocked(boolean accountNonBlocked) {
		this.accountNonLocked = accountNonBlocked;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
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
