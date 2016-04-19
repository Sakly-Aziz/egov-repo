package egov.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import egov.entities.Account;
import egov.entities.Intervention;
import egov.services.interfaces.IInterventionManagementLocal;

@Stateless
public class InterventionManagement implements IInterventionManagementLocal {
	@PersistenceContext
	EntityManager Us;
	
	@Override
	public Boolean addIntervention(Intervention i) {
		try {
			Us.persist(i);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean updateIntervention(Intervention i) {
		try {
			Us.merge(i);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public void flush() {
		Us.flush();

	}

	@Override
	public Boolean removeIntervention(Intervention i) {
		Us.remove(Us.merge(i));
		return true;

	}

	@Override
	public List<Intervention> findAll() {
		List<Intervention> interventions = new ArrayList<>();
		Query query = Us.createQuery("select i from Intervention i ");
		return query.getResultList();
	}

}
