package egov.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import egov.entities.Kase;
import egov.services.interfaces.ICaseManagementLocal;
import egov.services.interfaces.ICaseManagementRemote;

@Stateless
public class CaseManagement implements ICaseManagementRemote, ICaseManagementLocal {

	@PersistenceContext
	EntityManager Ca;

	public Boolean addCase(Kase c) {
		try {
			Ca.persist(c);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean update(Kase c) {
		try {
			Ca.merge(c);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void flush() {
		Ca.flush();

	}

	public Boolean remove(Kase c) {
		try {
			Ca.remove(Ca.merge(c));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Kase> findAll() {
		// List<Kase> cases = new ArrayList<>();
		String tx = "select c from Kase c";
		Query query = Ca.createQuery(tx);
		return query.getResultList();
	}

	@Override
	public Kase findCaseById(int id) {
		Kase cases = null;
		try {
			cases = Ca.find(Kase.class, id);

		} catch (Exception e) {

		}
		return cases;
	}

}
