package com.swap.JPA.onetomany;


public class OneToMany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Account fb = new Account();
		fb.setAccId(501);
		fb.setAccName("Facebook");
		
		Account ig = new Account(502, "Instagram");
		
		
		User user1 = new User();
		user1.setUserId(123);
		user1.setName("Swapnil");
		
		UserRepo ur = new UserRepo();
		ur.addUser(user1);
		ur.addAcc(123, fb);
		ur.addAcc(123, ig);
				
		User usr = ur.findUser(123);
		ur.removeAcc(123, ig);
		
	}

}
