package egov.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import egov.entities.Establishment;
import egov.services.interfaces.InscriptionManagementLocal;
import egov.services.interfaces.InscriptionManagementRemote;;

@Stateless
public class InscriptionManagement implements InscriptionManagementRemote, InscriptionManagementLocal {
	@PersistenceContext
	EntityManager Us;

	public Boolean addInscription(Establishment u) {

		try {
			Us.persist(u);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void flush() {
		Us.flush();
	}

	public Boolean update(Establishment u) {

		try {
			Us.merge(u);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public Boolean remove(Establishment u) {
		try {
			Us.remove(Us.merge(u));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void removeInscription(Establishment u) {
		Us.remove(Us.merge(u));

	}

	@Override
	public Establishment findInscriptionById(int idEstablishment) {
		Establishment univ = null;
		try {
			univ = Us.find(Establishment.class, idEstablishment);

		} catch (Exception e) {

		}
		return univ;
	}

	@Override
	public List<Establishment> findAll() {
		List<Establishment> iunivs = new ArrayList<>();
		Query query = Us.createQuery("select u from Establishment u");
		return query.getResultList();
	}

	@Override
	public Boolean removeInscriptionById(int idEstablishment) {
		Establishment univ = new Establishment();
		try {
			univ = Us.find(Establishment.class, idEstablishment);
			Us.remove(Us.merge(univ));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
