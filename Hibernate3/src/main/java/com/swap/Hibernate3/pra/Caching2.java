package com.swap.Hibernate3.pra;

import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Caching2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);

		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();

		SessionFactory sf = con.buildSessionFactory(sr);

		Session session1 = sf.openSession();

		Query<Alien> q1 = session1.createQuery("from Alien where aid=102");
		q1.setCacheable(true);
		Alien a = (Alien) q1.uniqueResult();
		System.out.println(a);
		session1.close();

		Session session2 = sf.openSession();

		Query<Alien> q2 = session2.createQuery("from Alien where aid=102");
		q2.setCacheable(true);
		a = (Alien) q2.uniqueResult();
		System.out.println(a);
		session2.close();
		sf.close();

	}

}
