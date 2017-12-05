package com.listapp.db;

import java.util.Date;


public class AppUser {
	private Integer id;
	private String name;
	private String lastName;
	private String username;
	private String password;
	private AppHouse houseId;
	private Date lastModified;
	
	
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
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	
	public AppHouse getHouseId() {
		return houseId;
	}
	public void setHouseId(AppHouse houseId) {
		this.houseId = houseId;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	
}
