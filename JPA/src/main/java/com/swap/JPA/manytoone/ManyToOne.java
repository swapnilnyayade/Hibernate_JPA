package com.swap.JPA.manytoone;


public class ManyToOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account fb = new Account();
		fb.setAccId(501);
		fb.setAccName("Facebook");
		
		Account ig = new Account(502, "Instagram");
		
		User user1 = new User();
		user1.setUserId(123);
		user1.setName("Swapnil");
		
		AccountRepo ar = new AccountRepo();
		ar.addAccount(ig);
		ar.addAccount(fb);
		
		ar.addUser(501, user1);
		ar.addUser(502, user1);
		
		//ar.removeUser(501, user1);
		ar.delete(fb);
		Account acc = ar.findAccount(501);
		
		System.out.println(acc);
	}

}
