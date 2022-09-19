package com.swap.Hibernate1.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class ManyToMany {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Project pro1 = new Project();
		pro1.setProId(101);
		pro1.setProName("Angular Assignment");
		
		Project pro2 = new Project(102, "Java Assignment");
		
		Emp emp1 = new Emp();
		emp1.setEmpId(1001);
		emp1.setName("Ajit");
		
		Emp emp2 = new Emp(1002, "Swapnil");
	
		List<Emp> emps = new ArrayList<>();
		emps.add(emp1);
		emps.add(emp2);
		pro1.setEmps(emps);
		
		List<Project> proj = new ArrayList<>();
		proj.add(pro1);
		proj.add(pro2);
		emp1.setPro(proj);
		

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(emp1);
		session.save(emp2);
		session.save(pro1);
		session.save(pro2);
		
		tx.commit();
		
		Project pro = (Project)session.get(Project.class, 101);
		System.out.println(pro);
		System.out.println(pro.getEmps());
		
		for(Emp emp: pro.getEmps()) 
			System.out.println(emp.getName());
		
		session.close();
		factory.close();
	}
}
