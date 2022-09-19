package com.swap.JPA.manytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class UserRepo {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public UserRepo() {
		
		this.emf = Persistence.createEntityManagerFactory("TestPersistence");
		this.em = emf.createEntityManager();
		
	}
	
	public User addUser(User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		return user;
	}
	
	public User findUser(int id) {
		
		return em.find(User.class, id);
	}
	
	public User updateUser(User user) {
		User userToUpdate = em.find(User.class, user.getUserId());
		em.getTransaction().begin();
		userToUpdate.setUserId(user.getUserId());
		userToUpdate.setName(user.getName());
		em.getTransaction().commit();
		return userToUpdate;
	}
	
	public void deleteUser(User user) {
		em.getTransaction().begin();
		em.remove(user);
		em.getTransaction().commit();
	
	}
	
	
	
	public void close() {
		this.em.close();
		this.emf.close();
	}
}
