package com.swap.Hibernate1.xml;

import java.io.FileInputStream;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.swap.Hibernate1.savefetch.Address;
import com.swap.Hibernate1.savefetch.Student;

public class Xml {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 	System.out.println( "Project Started!" );
	        SessionFactory factory = new Configuration().configure().buildSessionFactory();
	      
	        var p = new Person(101, "Swap", "Venkatesh Colony", "9370088773");
	        
	        Session session = factory.openSession();
	        
	        Transaction tx = session.beginTransaction();
	        
	        session.save(p);
	       
	        tx.commit();
	        
	        session.close();
	        factory.close();
	        
	        
	       
	}

}
