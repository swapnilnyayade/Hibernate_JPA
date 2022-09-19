package com.swap.JPA.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {
	@Id
	private int id;
	private String name;
	private String pass;
	
	
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(int id, String name, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", pass=" + pass + "]";
	}
	
	
}
