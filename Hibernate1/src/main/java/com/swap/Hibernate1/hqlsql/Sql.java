package com.swap.Hibernate1.hqlsql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class Sql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();
		
		NativeQuery q = session.createSQLQuery("select * from student");
		
		List<Object[]> list = q.list();
		
		for(Object[] std: list) {
			System.out.println(std[2] + " " + std[1]);
		}
		
		
		Transaction tx = session.beginTransaction();
		String sql = "delete from student where city=:c";
		NativeQuery nq = session.createSQLQuery(sql);
		
		nq.setParameter("c", "city1");
		int i = nq.executeUpdate();
		
		tx.commit();
		session.close();
		factory.close();
	}

}
