package com.swap.Hibernate2.manytomany;

import java.util.List;
import java.util.Set;

public class Project {
	
	private int proId;
	private String proName;
	private Set<Emp> emps;
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int proId, String proName, Set<Emp> emps) {
		super();
		this.proId = proId;
		this.proName = proName;
		this.emps = emps;
	}

	public Project(int proId, String proName) {
		super();
		this.proId = proId;
		this.proName = proName;
	}

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public Set<Emp> getEmps() {
		return emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Project [proId=" + proId + ", proName=" + proName + ", emps=" + emps + "]";
	}
	
	
}
