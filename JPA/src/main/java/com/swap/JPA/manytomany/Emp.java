package com.swap.JPA.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Emp {
	@Id
	private int empId;
	private String name;
	@ManyToMany(mappedBy = "emps")
	
	private List<Project> pro = new ArrayList<>();
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emp(int empId, String name) {
		super();
		this.empId = empId;
		this.name = name;
	}
	public Emp(int empId, String name, List<Project> pro) {
		super();
		this.empId = empId;
		this.name = name;
		this.pro = pro;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Project> getPro() {
		return pro;
	}
	public void setPro(List<Project> pro) {
		this.pro = pro;
	}
	
	 public void addPro(Project project) {
	        boolean added = pro.add(project);
	        if(added) {
	            project.getEmps().add(this);
	        }
	    }

	    public void removePro(Project project) {
	        boolean removed = pro.remove(this);
	        if(removed) {
	            project.getEmps().remove(this);
	        }
	    }
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", name=" + name + "]";
	}
	
	
	
	
}
