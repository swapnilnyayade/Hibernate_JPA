package com.swap.JPA.jpa;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class MemberRepo {

	private EntityManagerFactory emf;
	private EntityManager em;

	public MemberRepo() {

		this.emf = Persistence.createEntityManagerFactory("TestPersistence");
		this.em = emf.createEntityManager();

	}
	

	  public List<Member> getStudentWithCriteriaBuilder() {
	    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
	    CriteriaQuery<Member> criteriaQuery = criteriaBuilder.createQuery(Member.class);

	    Root<Member> memberRoot = criteriaQuery.from(Member.class);

	    criteriaQuery.select(memberRoot.get("name"));
	    criteriaQuery.distinct(true);
	    criteriaQuery.orderBy(criteriaBuilder.desc(memberRoot.get("name")));

	    CriteriaQuery<Member> select = criteriaQuery.select(memberRoot);
	    TypedQuery<Member> query = em.createQuery(select);

	    return query.getResultList();
	  }
	  
	  public List<Member> getMembersWithWHEREName() {

		    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		    CriteriaQuery<Member> query = criteriaBuilder.createQuery(Member.class);

		    Root<Member> from = query.from(Member.class);

		    List nameList = Arrays.asList(new String[]{"name2","pass2"});

		    Expression<String> exp = from.get("name");
		   
		    Predicate in = exp.in(nameList);
		   
		    query.where(in);
		    query.groupBy(from.get("pass"));

		    CriteriaQuery<Member> select = query.select(from);
		    TypedQuery<Member> query1 = em.createQuery(select);

		    return query1.getResultList();
		  }
}
