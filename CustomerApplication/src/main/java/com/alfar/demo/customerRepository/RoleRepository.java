package com.alfar.demo.customerRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alfar.demo.customerModel.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findByName(String string);
	
	

}
