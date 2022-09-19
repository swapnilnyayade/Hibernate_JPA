package com.swap.JPA.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//@DiscriminatorValue(value = "ST")
//@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Student extends Person{
	
	private String course;

	public Student(String firstName, String lastName, String course) {
		super(firstName, lastName);
		this.course = course;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [course=" + course + "]";
	}
	
	
	
}
