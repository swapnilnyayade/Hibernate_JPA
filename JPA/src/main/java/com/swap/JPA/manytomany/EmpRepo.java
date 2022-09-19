package com.swap.JPA.manytomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmpRepo {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public EmpRepo() {
		
		this.emf = Persistence.createEntityManagerFactory("TestPersistence");
		this.em = emf.createEntityManager();
		
	}
	
	public Emp addEmp(Emp emp) {
		em.getTransaction().begin();
		em.persist(emp);
		em.getTransaction().commit();
		return emp;
	}
	
	public Emp findEmp(int id) {
		
		return em.find(Emp.class, id);
	}
	
	public Emp updateEmp(Emp emp) {
		Emp empToUpdate = em.find(Emp.class, emp.getEmpId());
		em.getTransaction().begin();
		empToUpdate.setEmpId(emp.getEmpId());
		empToUpdate.setName(emp.getName());
		em.getTransaction().commit();
		return empToUpdate;
	}
	
	public void deleteEmp(Emp emp) {
		em.getTransaction().begin();
		em.remove(emp);
		em.getTransaction().commit();
	
	}
	
	 public void addProject(int id, Project project) {
		    em.getTransaction().begin();
		    Emp emp = findEmp(id);
		    if(emp != null) {
		     emp.getPro().add(project);
		    }
		    em.persist(emp);
		    em.getTransaction().commit();
		  }

		  public void removeProject(int id, Project project) {
			em.getTransaction().begin();
		    Emp emp = findEmp(id);
		    if(emp != null) {
		      emp.getPro().remove(project);
		    }
		    em.persist(emp);
		    em.getTransaction().commit();
		  }
	
	
	
	public void close() {
		this.em.close();
		this.emf.close();
	}
}
