package com.jsftemplate.bean;

import com.jsftemplate.utils.SessionUtils;

public class Home extends Form{

	/**
	 * Home bean
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	
	public String getUserName(){
		userName = SessionUtils.getUser().getName();
		return userName;
	}

}
