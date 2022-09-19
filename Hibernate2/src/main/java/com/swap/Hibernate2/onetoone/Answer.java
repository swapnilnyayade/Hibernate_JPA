package com.swap.Hibernate2.onetoone;

public class Answer {

	private int answerId;
	private String anser;
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
