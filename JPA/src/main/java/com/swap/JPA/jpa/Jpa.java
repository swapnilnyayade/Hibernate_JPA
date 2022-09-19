package com.swap.JPA.jpa;

import java.util.List;

public class Jpa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberRepo mr = new MemberRepo();
		List<Member> members = mr.getStudentWithCriteriaBuilder();

		members.forEach(System.out::println);

		members = mr.getMembersWithWHEREName();

		members.forEach(System.out::println);

	}

}
