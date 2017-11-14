package com.jsftemplate.bean;

import com.jsftemplate.utils.SessionUtils;

public class Header extends Form{

	/**
	 * Header bean
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean session;
	
	public void logOut(){
		SessionUtils.getSession().invalidate();
		redirect("/index.xhtml");
	}

	public boolean getSession() {
		session = SessionUtils.isValid();
		return session;
	}

	public void setSession(boolean session) {
		this.session = session;
	}

}
