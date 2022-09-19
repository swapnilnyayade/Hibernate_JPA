package com.swap.Hibernate3.pra;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.internal.SessionFactoryServiceRegistryBuilderImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println( "Project Started!" );
    	
    	Alien a1 = new Alien();
    	a1.setAid(102);
    	a1.setAname("abc");
    	a1.setColor("green");
    	
    	
    	
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
    	
        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();

	
    	SessionFactory sf = con.buildSessionFactory(sr);
    	
    	Session session = sf.openSession();
    	
    	Transaction tx = session.beginTransaction();
    	
    	session.save(a1);
    	
    	tx.commit();
    	session.close();
    	sf.close();
    	
    	
      
    }
}
