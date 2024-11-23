package com.ecimanagement.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ecimanagement.entity.Candidate;

public class Candidatedao {
	public Session getSession() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Candidate.class);
		return cfg.buildSessionFactory().openSession();
	}

	public List<Candidate> displayAllCandidates() {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Candidate> query = builder.createQuery(Candidate.class);
		Root<Candidate> root = query.from(Candidate.class);
		query.select(root);
		List<Candidate> listofallCandidates = getSession().createQuery(query).getResultList();
		return listofallCandidates;
	}

	public int insertCandidate(String cname, String pname, String constituency, String gender, String state, int age) {
		Integer stId = null;
		Session session = getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			stId = (Integer) session.save(new Candidate(cname, pname, constituency, gender, state, age));
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}
		return stId;

	}

	public boolean updateCandidate(String cname, String pname, String constituency, String gender, String state,
			int age, int cid) {

		boolean success = false;
		Session session = getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Candidate c = session.get(Candidate.class, cid);
			if (c != null) 
			{
			c.setC_name(cname);
			c.setParty_name(pname);
			c.setConstituency(constituency);
			c.setGender(gender);
			c.setState(state);
			c.setAge(age);
			session.update(c);
			tx.commit();
			success = true;
			}
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}
		return success;

	}

	public boolean deleteCandidate(int cid) {
		boolean msg=false;
		Session session = getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Candidate c = session.get(Candidate.class, cid);
			if (c != null) {
				session.delete(c);
				tx.commit();
				msg=true;
			}

			
			
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}
		return msg;
	}
}
