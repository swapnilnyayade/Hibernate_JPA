package com.swap.Hibernate1.hqlsql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.swap.Hibernate1.savefetch.Student;

public class Hql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		String query1 = "from Student as s where s.city=:c and name=:n";
		Query<Student> q = session.createQuery(query1);
		q.setParameter("c", "Jalgaon");
		q.setParameter("n", "Swapnil");
		
		List<Student> students = q.list(); 
		
		for(Student std: students) {
			System.out.println(std);
		}
		
		Transaction tx = session.beginTransaction();
		
		Query query2 = session.createQuery("delete from Student where city=:c");
		query2.setParameter("c", "Pune");
		int d = query2.executeUpdate();
		System.out.println("Deleted "+ d + " records");
		
		Query query3 = session.createQuery("update Student set city=:c where name=:n");
		query3.setParameter("c", "xyz");
		query3.setParameter("n", "Swapnil");
		int u = query3.executeUpdate();
		System.out.println("Updated "+ u + " records");
		
		tx.commit();
		
		Query query4 = session.createQuery("select u.userId, u.name, a.accName from User as u INNER JOIN u.acc as a");
		List<Object []> l = query4.getResultList();
		
		for(Object [] arr: l) {
			System.out.println(Arrays.toString(arr));
		}
		
		session.close();
		factory.close();

	}

}
