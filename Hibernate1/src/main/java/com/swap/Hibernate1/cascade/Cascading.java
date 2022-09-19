package com.swap.Hibernate1.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.swap.Hibernate1.onetomany.Account;
import com.swap.Hibernate1.onetomany.User;

public class Cascading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Account fb = new Account();
		fb.setAccId(501);
		fb.setAccName("Facebook");
		
		Account ig = new Account(502, "Instagram");
		
		
		User user1 = new User();
		user1.setUserId(123);
		user1.setName("Swapnil");
		
		fb.setUser(user1);
		ig.setUser(user1);
		
		List<Account> acc = new ArrayList<>();
		acc.add(fb);
		acc.add(ig);
		
		user1.setAcc(acc);
		
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(user1);
		

		tx.commit();
		session.close();
		factory.close();
		
	
	}

}
