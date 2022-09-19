package com.swap.Hibernate1.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LazyEager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		User usr = (User)session.get(User.class, 123);
		
		System.out.println(usr.getUserId());
		
		System.out.println(usr.getName());
		
		session.close();
		factory.close();
	}

	

}
