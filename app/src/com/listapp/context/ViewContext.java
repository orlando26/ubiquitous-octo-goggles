package com.listapp.context;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.listapp.bean.Header;
import com.listapp.bean.Home;
import com.listapp.bean.Login;
import com.listapp.bean.Register;

@ManagedBean
@ViewScoped
public class ViewContext implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Login login;

	private static Register register;

	private Home home;

	




	public Login getLogin() {
		if (login == null){
			login = new Login();
		}
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Register getRegister() {
		if (register == null){
			register = new Register();
		}
		return register;
	}

	public static void setRegister(Register reg) {
		register = reg;
	}

	public Home getHome() {
		if (home == null){
			home = new Home();
		}
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	
}
