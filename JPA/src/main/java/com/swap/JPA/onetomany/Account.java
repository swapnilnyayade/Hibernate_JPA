package com.swap.JPA.onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Account {
	@Id
	private int accId;
	private String accName;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "Account [accId=" + accId + ", accName=" + accName + "]";
	}
	
	

}
