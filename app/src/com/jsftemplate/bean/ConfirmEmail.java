package com.jsftemplate.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;

public class ConfirmEmail extends Form{

	/**
	 * Confirm Email bean
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{param.key}")
	private String key;
	private boolean valid = true;
	
	@PostConstruct
	public void init(){
		System.out.println(key);
	}
	
	public void test(){
		System.out.println("kdgnkdokngoda");
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
}
