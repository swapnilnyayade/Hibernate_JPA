package com.swap.JPA.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//@DiscriminatorValue(value = "TR")
//@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Teacher extends Person {

	private String Prof;

	public Teacher(String firstName, String lastName, String prof) {
		super(firstName, lastName);
		Prof = prof;
	}

	public String getProf() {
		return Prof;
	}

	public void setProf(String prof) {
		Prof = prof;
	}

	@Override
	public String toString() {
		return "Teacher [Prof=" + Prof + "]";
	}
	
	

	
}
