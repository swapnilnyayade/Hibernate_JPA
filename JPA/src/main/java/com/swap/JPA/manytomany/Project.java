package com.swap.JPA.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	private int proId;
	private String proName;
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "projects_employees",
            joinColumns =  { @JoinColumn(name = "pro_id") },
            inverseJoinColumns = { @JoinColumn(name = "emp_id") },
            uniqueConstraints = {
                    @UniqueConstraint(
                            columnNames = { "pro_id", "emp_id" }
                    )
            }

    )
	private List<Emp> emps = new ArrayList<>();
	
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

	 public void addEmp(Emp employee) {
	        boolean added = emps.add(employee);
	        if(added) {
	            employee.getPro().add(this);
	        }
	    }

	    public void removeEmp(Emp employee) {
	        boolean removed = emps.remove(employee);
	        if(removed) {
	            employee.getPro().remove(this);
	        }
	    }
	@Override
	public String toString() {
		return "Project [proId=" + proId + ", proName=" + proName + ", emps=" + emps + "]";
	}
	
	
}
