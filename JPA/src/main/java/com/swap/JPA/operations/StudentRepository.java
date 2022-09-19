package com.swap.JPA.operations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class StudentRepository {
	
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public StudentRepository() {
		
		this.emf = Persistence.createEntityManagerFactory("TestPersistence");
		this.em = emf.createEntityManager();
		
	}
	
	public Student addStudent(Student student) {
		em.getTransaction().begin();
		em.persist(student);
		em.getTransaction().commit();
		return student;
	}
	
	public Student findStudent(int id) {
		
		return em.find(Student.class, id);
	}
	
	public Student updateStudent(Student student) {
		Student studentToUpdate = em.find(Student.class, student.getId());
		em.getTransaction().begin();
		studentToUpdate.setName(student.getName());
		studentToUpdate.setCity(student.getCity());
		em.getTransaction().commit();
		return studentToUpdate;
	}
	
	public void deleteStudent(Student student) {
		em.getTransaction().begin();
		em.remove(student);
		em.getTransaction().commit();
	
	}
	
	public List<String> findNames() {
		
		Query query = em.createQuery("select s.name from Student s");
		return query.getResultList();
	}

	public List<String> findCities() {

		
		Query query = em.createQuery("select s.city from Student s");
		
		
		return query.getResultList();
	}

	public List<Object[]> getData() {

		
		Query query = em.createQuery("select city, name from Student");
		
		return query.getResultList();
	}
	
	public Student findById(int id) {
		Query query = em.createNamedQuery("find by id");
		query.setParameter("id", id);
		
		return (Student)query.getSingleResult();
	}
	
	public List<Student> findNameStartWith(String keyword) {
	
		Query query = em.createQuery("Select s from Student s where s.name like '" + keyword + "%'");
		return query.getResultList();
	
	}
	
	
	public Student updateNameById(String name, int id) {
		em.getTransaction().begin();
		Query query = em.createQuery("update Student set name = '" + name + "' where id = " + id);
		query.executeUpdate();
		em.getTransaction().commit();
		em.clear();
		return findById(id);
	}
	
	public void deleteById(int id) {
		em.getTransaction().begin();
		Query query = em.createQuery("delete from Student where id = " + id);
		query.executeUpdate();
		em.getTransaction().commit();
		
	}
	
	public List<Student> findSortingByName() {
		
		Query query = em.createQuery("select s from Student s order by s.name desc");
		return query.getResultList();
	
	}
	
	public Long count() {
		Query query = em.createQuery("select count(s) from Student s");
		return (Long)query.getSingleResult();
	}

	
	public void close() {
		this.em.close();
		this.emf.close();
	}
}
