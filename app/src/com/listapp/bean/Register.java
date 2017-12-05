package com.listapp.bean;

import java.util.Date;

import com.listapp.db.AppUser;
import com.listapp.hibernate.HibernateSession;
import com.listapp.utils.SHAHash;

public class Register extends Form{

	/**
	 * Register bean
	 */
	private static final long serialVersionUID = 1L;
	 
	private String name;
	
	private String lastName;
	
	private String email;
	
	private String password;

	private String confirmPassword;
	
	
	public Register(){
		cleanFields();
	}
	
	public void register(){
		AppUser user = new AppUser();
		if(password.equals(confirmPassword)){
			String hashedpassword = SHAHash.hash(password);
			user.setName(name);
			user.setLastName(lastName);
			user.setUsername(email);
			user.setPassword(hashedpassword);
			user.setLastModified(new Date());
			HibernateSession.saveObject(user);
			
			redirect("/index.xhtml");
		}else{
			System.out.println("Las contraseñas no coinciden");
		}
	}
	
	public void goBack(){
		redirect("/index.xhtml");
	}
	
	public void cleanFields(){
		name = null;
		lastName = null;
		email = null;
		password = null;
		confirmPassword = null;
	}
	
	/*Getters % Setters*/	
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
