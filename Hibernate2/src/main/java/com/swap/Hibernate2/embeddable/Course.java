package com.swap.Hibernate2.embeddable;

public class Course {
	private String name;
	private String dur;
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String name, String dur) {
		super();
		this.name = name;
		this.dur = dur;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDur() {
		return dur;
	}

	public void setDur(String dur) {
		this.dur = dur;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + ", dur=" + dur + "]";
	}
	
	
}
