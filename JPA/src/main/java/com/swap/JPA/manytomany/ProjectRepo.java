package com.swap.JPA.manytomany;

import java.lang.module.FindException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ProjectRepo {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public ProjectRepo() {
		
		this.emf = Persistence.createEntityManagerFactory("TestPersistence");
		this.em = emf.createEntityManager();
		
	}
	
	public Project addProject(Project project) {
		em.getTransaction().begin();
		em.persist(project);
		em.getTransaction().commit();
		return project;
	}
	
	public Project findProject(int id) {
		
		return em.find(Project.class, id);
	}
	
	public Project updateProject(Project project) {
		Project projectToUpdate = em.find(Project.class, project.getProId());
		em.getTransaction().begin();
		projectToUpdate.setProId(project.getProId());
		projectToUpdate.setProName(project.getProName());
		em.getTransaction().commit();
		return projectToUpdate;
	}
	
	public void deleteProject(Project project) {
		em.getTransaction().begin();
		em.remove(project);
		em.getTransaction().commit();
	
	}
	public void addEmp(int id, Emp emp) {
	    em.getTransaction().begin();
	     Project pro = findProject(id);
	    if(pro != null) {
	     pro.getEmps().add(emp);
	    }
	    em.persist(pro);
	    em.getTransaction().commit();
	  }

	  public void removeEmp(int id, Emp emp) {
		  em.getTransaction().begin();
	    Project pro = findProject(id);
	    if(pro != null) {
	    	pro.getEmps().remove(emp);
	    }
	    em.persist(pro);
	    em.getTransaction().commit();
	  }
	
	
	public void close() {
		this.em.close();
		this.emf.close();
	}
}
