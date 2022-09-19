package com.swap.Hibernate1.firstandsecondcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cache.ehcache.internal.EhcacheRegionFactory;
import org.hibernate.cfg.Configuration;

import com.swap.Hibernate1.savefetch.Student;

public class FandSLevelCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
	    
	        Session session1 = factory.openSession();
	        
	        Student st1 = (Student)session1.get(Student.class, 2);
	        System.out.println(st1);
	        
	        Student st2 = (Student)session1.get(Student.class, 2);
	        System.out.println(st2);
	        session1.close();
	        
	        Session session2 = factory.openSession();
	        
	        Student st3 = (Student)session2.get(Student.class, 2);
	        System.out.println(st3);
	       
	        session2.close();
	        factory.close();
	       
	}

}
