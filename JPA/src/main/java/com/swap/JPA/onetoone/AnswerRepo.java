package com.swap.JPA.onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AnswerRepo {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public AnswerRepo() {
		
		this.emf = Persistence.createEntityManagerFactory("TestPersistence");
		this.em = emf.createEntityManager();
		
	}
	
		public AnswerRepo(int no) {
		
		
	}
	
	
	public Answer addAnswer(Answer answer) {
		em.getTransaction().begin();
		em.persist(answer);
		em.getTransaction().commit();
		return answer;
	}
	
	public Answer findAnswer(int id) {
		
		return em.find(Answer.class, id);
	}
	
	public Answer updateAnswer(Answer answer) {
		Answer answerToUpdate = em.find(Answer.class, answer.getAnswerId());
		em.getTransaction().begin();
		answerToUpdate.setAnser(answer.getAnser());
		answerToUpdate.setQue(answer.getQue());
		em.getTransaction().commit();
		return answerToUpdate;
	}
	
	public void deleteAnswer(Answer answer) {
		em.getTransaction().begin();
		em.remove(answer);
		em.getTransaction().commit();
	
	
	}
	
	public Answer addQue(int id, Question question) {
		em.getTransaction().begin();
		Answer answer = findAnswer(id);
		answer.setQue(question);;
//		em.persist(question);
//		question.setAns(answer);
		em.getTransaction().commit();
		return answer;
	}
	
	public void close() {
		this.em.close();
		this.emf.close();
	}
}
