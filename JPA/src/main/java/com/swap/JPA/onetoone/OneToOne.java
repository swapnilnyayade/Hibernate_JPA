package com.swap.JPA.onetoone;

public class OneToOne {
	public static void main(String[] args) {
		 
		 Answer a1 = new Answer();
		 a1.setAnswerId(101);
		 a1.setAnser("My name is Swapnil");
		 
		 Question q1 = new Question();
		 q1.setQuestionId(1);
		 q1.setQuestion("What is your name?");

		
		
		 QuestionRepo qr = new QuestionRepo();
		 qr.addQuestion(q1);
		 qr.addAns(1, a1);
		
		 
		 
		 Question que = qr.findQuestion(1);
		 System.out.println(que);
		 System.out.println(que.getAns());
		 System.out.println(que.getAns().getAnser());
		 
		 q1.setQuestion("Who are you?");
		 qr.updateQuestion(q1);
		
		 qr.close();
		 
		AnswerRepo ar = new AnswerRepo();
		ar.deleteAnswer(ar.findAnswer(101));
		System.out.println(ar.findAnswer(101));
		
		
		
		 
		
	}

}
