package com.listapp.hibernate;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
public class HibernateSession {
	private static final SessionFactory sessionFactory;
	private static Session session;

	static{
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
				applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory();
	}

	public static void saveObject(Object object){
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(object);
		session.getTransaction().commit();
		session.close();
	}

	public static <T> Object getObjectByPrimaryKey(Class <T> objectClass, Serializable pk){
		session = sessionFactory.openSession();
		session.beginTransaction();
		Object obj = session.get(objectClass, pk);
		session.close();
		return obj; 
	}
	public static Session getSession() {
		session = sessionFactory.openSession();
		return session;
	}

	public static void setSession(Session session) {
		HibernateSession.session = session;
	}


}
