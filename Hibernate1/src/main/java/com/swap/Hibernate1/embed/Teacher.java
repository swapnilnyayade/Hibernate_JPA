package com.swap.Hibernate1.embed;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teacher {
	@Id
	private int id;
	private String tname;
	private long mob;
	private Course crs;
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(int id, String tname, long mob, Course crs) {
		super();
		this.id = id;
		this.tname = tname;
		this.mob = mob;
		this.crs = crs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public long getMob() {
		return mob;
	}

	public void setMob(long mob) {
		this.mob = mob;
	}

	public Course getCrs() {
		return crs;
	}

	public void setCrs(Course crs) {
		this.crs = crs;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", tname=" + tname + ", mob=" + mob + ", crs=" + crs + "]";
	}
	
	

}
