package fte.tests.jeerestcdi.rest.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import fte.tests.jeerestcdi.rest.entity.Greet;

public class GreetService {
	
	@PersistenceContext(unitName="em1")
	private EntityManager em;
	
	@Transactional
	public String greet(String name) {
		Greet greet = new Greet();
		greet.setName(name);
		em.persist(greet);
		return "Hello "+ name;
	}
	
	@SuppressWarnings("unchecked")
	public List<Greet> getAll() {
		return em.createQuery("Select e from Greet e").getResultList();
	}

}