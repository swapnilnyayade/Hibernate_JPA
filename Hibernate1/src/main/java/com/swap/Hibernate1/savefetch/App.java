package com.swap.Hibernate1.savefetch;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
	@SuppressWarnings("resource")
	public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Started!" );
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        System.out.println(factory);
        System.out.println(factory.isClosed());
        
        Student st1 = new Student();
        st1.setId(101);
        st1.setName("Swapnil Nyayade");
        st1.setCity("Jalgaon");
        
        Student st2 = new Student(102, "Ajit Nyayade", "Pune");
        
        Address ad1 = new Address();
        ad1.setStreet("chirch road");
        ad1.setCity("jalgaon");
        ad1.setOpen(true);
        ad1.setX(3.142);
        ad1.setDate(new Date());
        
        
		FileInputStream fis1 = new FileInputStream("src/main/java/jalgaon.jpg");
        byte[] data1 = new byte[fis1.available()];
        fis1.read(data1);
        
        ad1.setImage(data1);
        
        FileInputStream fis2 = new FileInputStream("src/main/java/pune.jpg");
        byte[] data2 = new byte[fis2.available()];
        fis2.read(data2);
        
        Address ad2 = new Address("pune highway", "pune", true, 3.142, new Date(), data2);
        
        
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(st1);
        session.save(st2);
        session.save(ad1);
        session.save(ad2);
        
        tx.commit();
        
        session.close();
        factory.close();
        System.out.println(factory.isClosed());
    }
}
