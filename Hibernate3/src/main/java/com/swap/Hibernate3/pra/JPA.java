package com.swap.Hibernate3.pra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		
		Alien a = new Alien();
		a.setAid(105);
		a.setAname("bongo");
		a.setColor("blue");
		
		Alien a1 = new Alien();
		a1.setAid(110);
		a1.setAname("rambo");
		a1.setColor("red");
		
		em.getTransaction().begin();
		
		em.persist(a);
		em.persist(a1);
		
		em.remove(a);
		em.getTransaction().commit();
		
		a = em.find(Alien.class, 105);
		a1 = em.find(Alien.class, 110);
		
		System.out.println(a);
		System.out.println(a1);
		
		a1.setAname("gogo");
		
		System.out.println(a1);
		
		em.close();
		emf.close();
	}
	

}
