package com.alfar.spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Table
@Entity
public class Role implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	
	public Role() {}

 public Role(Integer id, String name, List<Permission> permissions) {
		
		this.id = id;
		this.name = name;
		this.permissions = permissions;
	}
 





	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name= "permission_role",joinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name= "permission_id", referencedColumnName = "id")})
	private List<Permission> permissions;
	
	
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


	public List<Permission> getPermissions() {
		return permissions;
	}


	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}



}
