package com.jsftemplate.bean;

import com.jsftemplate.db.AppUser;
import com.jsftemplate.hibernate.HibernateSession;
import com.jsftemplate.utils.Email;
import com.jsftemplate.utils.SHAHash;

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
			user.setEmail(email);
			user.setPassword(hashedpassword);
			user.setConfirmed(false);
			HibernateSession.saveObject(user);
			String url = getRequest().getRequestURL().toString();
			String newUrl = url.replace("register", "confirmemail");
			newUrl += "?key=" + name;
			Email mailObject = new Email();
			mailObject.setTo(email);
			mailObject.setSubject("Email Confirmation");
			mailObject.setMessage("Welcome" + name + "/nyou can confirm your email in the following link./n" + newUrl);
			mailObject.send();
			
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
