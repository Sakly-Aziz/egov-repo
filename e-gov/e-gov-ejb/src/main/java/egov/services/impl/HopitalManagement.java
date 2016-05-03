package egov.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import egov.entities.Hopital;
import egov.services.interfaces.IHopitalManagement;



@Stateless
public class HopitalManagement implements IHopitalManagement  {
	@PersistenceContext
	EntityManager em;
	

	public Boolean addHopital(Hopital a) {
		try {
			em.persist(a);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean updateHopital(Hopital a) {
		try {
			em.merge(a);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void flush() {
		em.flush();

	}

	public Boolean removeHopital(Hopital a) {
		em.remove(em.merge(a));
		return true;

	}

	public List<Hopital> findAll() {
		List<Hopital> hopitals = new ArrayList<>();
		Query query = em.createQuery("select a from Hopital a ");
		return query.getResultList();
	}


}
