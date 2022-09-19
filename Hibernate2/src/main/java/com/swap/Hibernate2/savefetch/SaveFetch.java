package com.swap.Hibernate2.savefetch;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class SaveFetch {

	public static void main(String[] args) throws IOException, SQLException {
		// TODO Auto-generated method stub
		 	System.out.println( "Project Started!" );
	        SessionFactory factory = new Configuration().configure().buildSessionFactory();
	        Session session = factory.openSession();
	        
	        Address ad1 = new Address();
	        ad1.setStreet("chirch road");
	        ad1.setCity("jalgaon");
	        ad1.setOpen(true);
	        ad1.setX(3.142);
	        ad1.setDate(new Date());
	        
	        
			FileInputStream fis1 = new FileInputStream("src/main/java/jalgaon.jpg");
	        byte[] data1 = new byte[fis1.available()];
	        fis1.read(data1);
	      
	        Blob photo = Hibernate.getLobCreator(session).createBlob(data1);
	        
	        ad1.setImage(photo);
	        
	        Transaction tx = session.beginTransaction();
	        
	       
	        session.save(ad1);
	        
	        
	        tx.commit();
	        byte[] b = photo.getBytes(1, data1.length);
	        System.out.println(Arrays.toString(b));
	        
	        Address ad = (Address)session.get(Address.class, 1);
	        System.out.println(ad.getImage());
	        
	        session.close();
	        factory.close();
	        System.out.println(factory.isClosed());
	}

}
