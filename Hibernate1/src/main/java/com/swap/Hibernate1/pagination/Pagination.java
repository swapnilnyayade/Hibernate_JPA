package com.swap.Hibernate1.pagination;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.swap.Hibernate1.savefetch.Student;

public class Pagination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		Query q = session.createQuery("from Student");
		q.setFirstResult(4);
		q.setMaxResults(5);
		
		List<Student> stds = q.list();
		
		for(Student std : stds) {
			System.out.println(std);
		}
		
		
		
		
		session.close();
		factory.close();
	}

}
