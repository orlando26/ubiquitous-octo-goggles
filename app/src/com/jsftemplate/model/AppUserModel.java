package com.jsftemplate.model;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.jsftemplate.db.AppUser;
import com.jsftemplate.hibernate.HibernateSession;
import com.jsftemplate.hibernate.SQL;

public class AppUserModel {
	@SuppressWarnings("unchecked")
	public static AppUser findByUserName(String userName){
		Session session = HibernateSession.getSession();
		session.beginTransaction();
		SQLQuery query = SQL.getQueryByEntity(session, AppUser.class, "findByUserName");
		query.setParameter("userName", userName);
		List<AppUser> list = query.list();
		session.close();
		AppUser user;
		try{
			user =  list.get(0);
		}catch(IndexOutOfBoundsException e){
			user = null;
		}
		return user;
	}
}
