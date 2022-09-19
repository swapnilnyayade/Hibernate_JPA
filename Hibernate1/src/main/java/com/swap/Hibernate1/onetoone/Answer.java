package com.swap.Hibernate1.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Answer {
	@Id
	private int answerId;
	private String anser;
	@OneToOne(mappedBy="ans")
	private Question que;
	
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Answer(int answerId, String anser, Question que) {
		super();
		this.answerId = answerId;
		this.anser = anser;
		this.que = que;
	}
	
	public Answer(int answerId, String anser) {
		super();
		this.answerId = answerId;
		this.anser = anser;

	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnser() {
		return anser;
	}

	public void setAnser(String anser) {
		this.anser = anser;
	}

	public Question getQue() {
		return que;
	}

	public void setQue(Question que) {
		this.que = que;
	}

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", anser=" + anser + ", que=" + que + "]";
	}
	
	
}
