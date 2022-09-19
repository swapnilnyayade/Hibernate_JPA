package com.swap.Hibernate1.embed;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Embed {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Course crs1 = new Course();
		crs1.setName("Java");
		crs1.setDur("3 Month");
		
		Teacher t1 = new Teacher();
		t1.setId(1001);
		t1.setTname("Neha Mam");
		t1.setMob(8411954622l);
		t1.setCrs(crs1);
		
		Course crs2 = new Course("Python", "2 Months");
		Teacher t2 = new Teacher(1002, "Rahul sir", 9226785325l, crs2);
		
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(t1);
		session.save(t2);
		tx.commit();
		session.close();
		factory.close();
		
	}

}
