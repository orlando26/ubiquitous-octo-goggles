package com.listapp.bean;

import javax.faces.application.FacesMessage;

import com.listapp.context.SessionContext;
import com.listapp.context.ViewContext;
import com.listapp.db.AppUser;
import com.listapp.model.AppUserModel;
import com.listapp.utils.SHAHash;
import com.listapp.utils.SessionUtils;

public class Login extends Form{

	/**
	 * login Bean
	 */
	private static final long serialVersionUID = 1L;

	private String userName;

	private String password;

	public void logIn(){
		if(userName == "" || password == ""){
			errorMessage("Fill all the fields!");
			return;
		}
		AppUser user = AppUserModel.findByUserName(userName);
		if(validateUser(user)){
			SessionUtils.setUserLogged(user);
			redirect("/pages/home.xhtml");
		}

	}

	public boolean validateUser(AppUser user){
		String hashedPassword = SHAHash.hash(password);
		if(user == null){
			errorMessage("user doesn't exist!");
			return false;
		}
		if(!user.getPassword().equals(hashedPassword)){
			errorMessage("incorrect password");
			return false;
		}
		return true;
	}

	public void regPage(){
		System.out.println("Register");
		ViewContext.setRegister(null);
		redirect("/pages/register.xhtml");
	}

	public void errorMessage(String message){
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error!", message));
	}

	/* Getters & Setters */
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
