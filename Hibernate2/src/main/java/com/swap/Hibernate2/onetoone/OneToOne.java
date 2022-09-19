package com.swap.Hibernate2.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 SessionFactory factory = new Configuration().configure().buildSessionFactory();
		 
		 Answer a1 = new Answer();
		 
		 a1.setAnser("My name is Swapnil");
		 
		 Question q1 = new Question();
		
		 q1.setQuestion("What is your name?");
		 q1.setAns(a1);
		 a1.setQue(q1);
		 
		 Answer a2 = new Answer();
		 
		 a2.setAnser("My favourite color is black");
		 Question q2 = new Question();
		
		 q2.setQuestion("What is your favourite color?");
		 q2.setAns(a2);
		 a2.setQue(q2);
		 
		 Session session = factory.openSession();
		 Transaction tx = session.beginTransaction();
		 
		 session.save(q1);
	
		 session.save(q2);
		 
		 
		 tx.commit();
		 
		 Question que1 = (Question)session.get(Question.class, 501);
		 System.out.println(que1);
		 Answer ans1 = (Answer)session.get(Answer.class, 102);
		 System.out.println(ans1);
//		 System.out.println(que1.getAns());
//		 System.out.println(que1.getAns().getAnser());
		 session.close();
		 factory.close();

	}

}
