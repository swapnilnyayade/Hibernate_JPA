package com.swap.Hibernate1.manytomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	private int proId;
	private String proName;
	@ManyToMany(mappedBy="pro")
	private List<Emp> emps;
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int proId, String proName, List<Emp> emps) {
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

	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Project [proId=" + proId + ", proName=" + proName + ", emps=" + emps + "]";
	}
	
	
}
