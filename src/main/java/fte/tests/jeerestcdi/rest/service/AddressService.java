package fte.tests.jeerestcdi.rest.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import fte.tests.jeerestcdi.rest.entity.Address;

public class AddressService {
	
	@PersistenceContext(unitName="em1")
	private EntityManager em;
	
	@Transactional
	public Address save(Address aAddress) {
		em.persist(aAddress);
		return aAddress;
	}
	
	@Transactional
	public Address update(Address aAddress) {
		return em.merge(aAddress);
	}
	
	@Transactional
	public void delete(Long id) {
		Address address = find(id);
		System.out.println(address);
		em.remove(address);
	}
	
	public Address find(Long id) {
		return em.find(Address.class, id);
	}
	
	public List<Address> findAll() {
		return em.createQuery("Select a from Address a").getResultList();
	}

}
