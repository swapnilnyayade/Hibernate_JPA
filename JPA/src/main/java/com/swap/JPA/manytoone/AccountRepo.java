package com.swap.JPA.manytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class AccountRepo {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public AccountRepo() {
		
		this.emf = Persistence.createEntityManagerFactory("TestPersistence");
		this.em = emf.createEntityManager();
		
	}
	
	public Account addAccount(Account account) {
		em.getTransaction().begin();
		em.persist(account);
		em.getTransaction().commit();
		return account;
	}
	
	public Account findAccount(int id) {
		
		return em.find(Account.class, id);
	}
	
	public Account updateAccount(Account account) {
		Account accountToUpdate = em.find(Account.class, account.getAccId());
		em.getTransaction().begin();
		accountToUpdate.setAccId(account.getAccId());
		accountToUpdate.setAccName(account.getAccName());
		em.getTransaction().commit();
		return accountToUpdate;
	}
	
	public void delete(Account account) {
		em.getTransaction().begin();
		em.remove(account);
		em.getTransaction().commit();
	
	}
	
	public Account addUser(int id, User user) {
		em.getTransaction().begin();
		Account acc = findAccount(id);
		
		if(acc != null) {
			acc.setUser(user);
		}
		
		//em.persist(user);
		em.getTransaction().commit();
		return acc;
	}
	
	public Account removeUser(int id, User user) {
		em.getTransaction().begin();
		Account acc = findAccount(id);
		
		if(acc != null) {
			acc.setUser(null);
		}
		
		//em.persist(user);
		em.getTransaction().commit();
		return acc;
	}

	
	public void close() {
		this.em.close();
		this.emf.close();
	}
}
