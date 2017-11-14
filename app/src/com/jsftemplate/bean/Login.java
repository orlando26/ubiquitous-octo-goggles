package com.jsftemplate.bean;

import javax.faces.application.FacesMessage;

import com.jsftemplate.context.SessionContext;
import com.jsftemplate.db.AppUser;
import com.jsftemplate.model.AppUserModel;
import com.jsftemplate.utils.SHAHash;
import com.jsftemplate.utils.SessionUtils;

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
		if(!user.getConfirmed()){
			errorMessage("user not yet confirmed! check your email.");
			return false;
		}
		return true;
	}

	public void regPage(){
		System.out.println("Register");
		SessionContext.setRegister(null);
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
