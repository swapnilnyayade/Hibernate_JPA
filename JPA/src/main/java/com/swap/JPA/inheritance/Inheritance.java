package com.swap.JPA.inheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Inheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		
		
		Person st1 = new Student("Swapnil", "Nyayade", "Java");
		Person st2 = new Student("Ajit", "Nyayade", "Python");
		
		Person tr1 = new Teacher("Neha", "Patil", "AP");
		Person tr2 = new Teacher("Tanuja", "Borase", "HOD");
		
		em.getTransaction().begin();
		em.persist(st1);
		em.persist(st2);
		em.persist(tr1);
		em.persist(tr2);
		em.getTransaction().commit();
	}

	
	
}
