package com.alfar.demo.customerModel;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name = "user")
@Entity
public class Customer implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String username;

	private int age;
	private String gender;
	private String email;
	private String password;
	
	
	
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean enabled;
	@Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean accountNonExpired;
	@Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean credentialsNonExpired;
	@Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean accountNonLocked;
	
	
	
	public Customer(Integer id, String username, int age, String gender, String email, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Address address,
			List<Telephone> telephone,List<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.accountNonExpired = accountNonExpired;
		this.credentialsNonExpired = credentialsNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.address = address;
		this.telephone = telephone;
		this.roles = roles;
	}


	 
	    public Customer() {
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



	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}


		

	@JsonIgnore
	public String getPassword() {
		return password;
	}


    @JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}


	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	
	@OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)
	private List<Telephone> telephone;
	
	 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinTable(name = "role_user", joinColumns = {
	    		
	            @JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {
	            		
	            @JoinColumn(name = "role_id", referencedColumnName = "id")})
	    private List<Role> roles;
	
	
	
	public Integer getId() {
		return id;
	}



	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + username + ", age=" + age + ", gender=" + gender + ", email=" + email
				+ ", password=" + password + ", enabled=" + enabled + ", accountNonExpired=" + accountNonExpired
				+ ", credentialsNonExpired=" + credentialsNonExpired + ", accountNonLocked=" + accountNonLocked
				+ ", address=" + address + ", telephone=" + telephone + ", roles=" + roles + "]";
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
		this.gender = gender;
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



	public List<Role> getRoles() {
		return roles;
	}



	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	

	

	
	
	
	
	
	

}
