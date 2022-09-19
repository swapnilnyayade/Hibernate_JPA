package com.swap.JPA.manytomany;

import java.util.ArrayList;
import java.util.List;


public class ManyToMany {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
		
		ProjectRepo pr = new ProjectRepo();
		pr.addProject(pro1);
		pr.addProject(pro2);
	
		pr.removeEmp(101, emp2);
		
		EmpRepo er = new EmpRepo();
		Emp emp = er.findEmp(1002);
		er.deleteEmp(emp);
		
		
	}

}
