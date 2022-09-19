package com.swap.Hibernate1.onetoone;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOne {
	public static void main(String[] args) {
		 SessionFactory factory = new Configuration().configure().buildSessionFactory();
		 
		 Answer a1 = new Answer();
		 a1.setAnswerId(101);
		 a1.setAnser("My name is Swapnil");
		 
		 Question q1 = new Question();
		 q1.setQuestionId(1);
		 q1.setQuestion("What is your name?");
		 q1.setAns(a1);
		 a1.setQue(q1);
		 
		 Answer a2 = new Answer(102, "My favourite color is black");
		 Question q2 = new Question(2, "What is your favourite color?", a2);
		 a2.setQue(q2);
		 
		 Session session = factory.openSession();
		 Transaction tx = session.beginTransaction();
		 
		 session.save(q1);
		 session.save(a1);
		 session.save(q2);
		 session.save(a2);
		 
		 tx.commit();
		 
		 Question que1 = (Question)session.get(Question.class, 1);
		 System.out.println(que1);
//		 System.out.println(que1.getAns());
//		 System.out.println(que1.getAns().getAnser());
		 session.close();
		 factory.close();
	}

}
