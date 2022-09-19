package com.swap.Hibernate2.manytomany;

import java.util.List;
import java.util.Set;


public class Emp {
	
	private int empId;
	private String name;

	private Set<Project> pro;
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emp(int empId, String name) {
		super();
		this.empId = empId;
		this.name = name;
	}
	public Emp(int empId, String name, Set<Project> pro) {
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
	
	public Set<Project> getPro() {
		return pro;
	}
	public void setPro(Set<Project> pro) {
		this.pro = pro;
	}
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", name=" + name + "]";
	}
	
	
	
	
}
