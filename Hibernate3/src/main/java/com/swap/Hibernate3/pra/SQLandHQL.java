package com.swap.Hibernate3.pra;

import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import org.hibernate.service.ServiceRegistry;

public class SQLandHQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);

		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();

		SessionFactory sf = con.buildSessionFactory(sr);

		Session session = sf.openSession();

		Query q1 = session.createQuery("select aid, aname, color from Alien where aid=101");
		Object[] a1 = (Object[])q1.uniqueResult();
		System.out.println(a1[0] + " : " + a1[1] + " : " + a1[2]);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		Query q2 = session.createQuery("select sum(id) from Alien a where a.aid>105");
		Long sum = (Long)q2.uniqueResult();
		System.out.println(sum);
		
		SQLQuery q3 = session.createSQLQuery("select aname,color from alien where aid<106");
		q3.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List aliens = q3.list();
		
		for(Object o: aliens) {
			Map m = (Map)o;
			System.out.println(m.get("aname") + " : " + m.get("color"));
		}
		
		session.close();
		sf.close();

	}

}
