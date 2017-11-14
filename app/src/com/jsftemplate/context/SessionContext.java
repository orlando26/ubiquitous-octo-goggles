package com.jsftemplate.context;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.jsftemplate.bean.ConfirmEmail;
import com.jsftemplate.bean.Header;
import com.jsftemplate.bean.Home;
import com.jsftemplate.bean.Login;
import com.jsftemplate.bean.Register;

@ManagedBean
@SessionScoped
public class SessionContext implements Serializable{

	/**
	 * SessionContext Bean
	 */
	private static final long serialVersionUID = 1L;
	
	private Login login;
	
	private static Register register;
	
	private Home home;
	
	private Header header;
	



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

	public Header getHeader() {
		if(header == null){
			header = new Header();
		}
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	

}
