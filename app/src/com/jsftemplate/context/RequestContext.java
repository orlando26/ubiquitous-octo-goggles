package com.jsftemplate.context;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.jsftemplate.bean.ConfirmEmail;

@ManagedBean
@RequestScoped
public class RequestContext implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private ConfirmEmail confirm;
	
	
	public ConfirmEmail getConfirm() {
		if(confirm == null){
			confirm = new ConfirmEmail();
		}
		return confirm;
	}

	public void setConfirm(ConfirmEmail confirm) {
		this.confirm = confirm;
	}
	

}
