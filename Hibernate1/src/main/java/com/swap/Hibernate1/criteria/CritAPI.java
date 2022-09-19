package com.swap.Hibernate1.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.swap.Hibernate1.embed.Course;
import com.swap.Hibernate1.embed.Teacher;

public class CritAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		Criteria c = session.createCriteria(Teacher.class);
		List<Teacher> list = c.list();
		
		for(Teacher t: list) {
			System.out.println(t);
		}
		
		Criteria c1 = session.createCriteria(Teacher.class);
		c1.add(Restrictions.eq("crs.name", "java"));
		List<Teacher> list1 = c1.list();
		
		for(Teacher t: list1) {
			System.out.println(t);
		}
		
		Criteria c2 = session.createCriteria(Teacher.class);
		c2.add(Restrictions.lt("id", 3)); //less than
		List<Teacher> list2 = c2.list();
		
		for(Teacher t: list2) {
			System.out.println(t);
		}
		
		Criteria c3 = session.createCriteria(Teacher.class);
		c3.add(Restrictions.like("crs.name", "python%")); //less than
		List<Teacher> list3 = c3.list();
		
		for(Teacher t: list3) {
			System.out.println(t);
		}
		
		session.close();
		factory.close();
	}

}
