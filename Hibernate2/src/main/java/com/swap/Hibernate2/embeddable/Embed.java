package com.swap.Hibernate2.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Embed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println( "Project Started!" );
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
      
        Teacher t = new Teacher();
        t.setId(101);
        t.setTname("Swapnil");
        t.setMob(1789453322);
        
        Course crs = new Course();
        crs.setName("Java");
        crs.setDur("5");
        
        t.setCrs(crs);
        
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(t);
       
        tx.commit();
        
        session.close();
        factory.close();
        
	}

}
