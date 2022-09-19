package com.swap.Hibernate1.manytomany;

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
	@ManyToMany
	@JoinTable(name="EmployeeProject", joinColumns = {@JoinColumn(name="emp_id")}, inverseJoinColumns = {@JoinColumn(name="pro_id")})
	private List<Project> pro;
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
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", name=" + name + "]";
	}
	
	
	
	
}
