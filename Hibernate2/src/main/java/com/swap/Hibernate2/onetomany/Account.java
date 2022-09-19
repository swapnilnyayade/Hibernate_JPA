package com.swap.Hibernate2.onetomany;

public class Account {
	
	private int accId;
	private String accName;
	
	private User user;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int accId, String accName, User user) {
		super();
		this.accId = accId;
		this.accName = accName;
		this.user = user;
	}
	
	public Account(int accId, String accName) {
		super();
		this.accId = accId;
		this.accName = accName;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Account [accId=" + accId + ", accName=" + accName + ", user=" + user + "]";
	}
	
	

}
