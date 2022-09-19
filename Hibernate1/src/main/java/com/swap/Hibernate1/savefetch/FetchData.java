package com.swap.Hibernate1.savefetch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Student st1 = (Student)session.get(Student.class, 101);
		System.out.println(st1);
		
		Student st2 = (Student)session.get(Student.class, 101);
		System.out.println(st2);
		
		Student st3 = (Student)session.get(Student.class, 105);
		System.out.println(st3);
		
		Student st4 = (Student)session.load(Student.class, 101);
		System.out.println(st4.getId());
		
		session.close();
		factory.close();
		System.out.println();
	}
}
