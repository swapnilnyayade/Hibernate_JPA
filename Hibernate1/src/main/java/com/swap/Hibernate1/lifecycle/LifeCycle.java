package com.swap.Hibernate1.lifecycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LifeCycle {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		//Transient state
		Student st = new Student();
		
		st.setId(101);
		st.setName("Ajit Nyayade");
		st.setCity("Mumbai");
		   
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		//Persistent state
		session.save(st);
		
		st.setName("Ramesh Nyayade");
		
		//session.delete(st);
		
		tx.commit();
		
		session.close();
		//session.update(st);
		
		st.setCity("Nashik");
		
		System.out.println(st);
	   
		factory.close();
	}


}
