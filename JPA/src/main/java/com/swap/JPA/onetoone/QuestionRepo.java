package com.swap.JPA.onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class QuestionRepo {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public QuestionRepo() {
		
		this.emf = Persistence.createEntityManagerFactory("TestPersistence");
		this.em = emf.createEntityManager();
		
	}
	
	public Question addQuestion(Question question) {
		em.getTransaction().begin();
		em.persist(question);
		em.getTransaction().commit();
		return question;
	}
	
	public Question findQuestion(int id) {
		
		return em.find(Question.class, id);
	}
	
	public Question updateQuestion(Question question) {
		Question questionToUpdate = em.find(Question.class, question.getQuestionId());
		em.getTransaction().begin();
		questionToUpdate.setQuestion(question.getQuestion());
		questionToUpdate.setAns(question.getAns());
		em.getTransaction().commit();
		return questionToUpdate;
	}
	
	public void deleteQuestion(Question question) {
		em.getTransaction().begin();
		em.remove(question);
		em.getTransaction().commit();
	
	}
	
	public Question addAns(int id, Answer answer) {
		em.getTransaction().begin();
		Question question = findQuestion(id);
		
		question.setAns(answer);
		
		em.getTransaction().commit();
		return question;
	}
	
	public void close() {
		this.em.close();
		this.emf.close();
	}
}
