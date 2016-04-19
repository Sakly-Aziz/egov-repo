package egov.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import egov.entities.Establishment;
import egov.entities.University;
import egov.entities.User;
import egov.services.interfaces.InscriptionManagementLocal;
import egov.services.interfaces.InscriptionManagementRemote;

@Stateless
public class InscriptionManagement implements InscriptionManagementRemote, InscriptionManagementLocal {

	@PersistenceContext
	private EntityManager entityManager;

	public Boolean addInscription(Establishment u) {

		try {
			entityManager.persist(u);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void flush() {
		entityManager.flush();
	}

	public Boolean update(Establishment u) {

		try {
			entityManager.merge(u);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public Boolean remove(Establishment u) {
		try {
			entityManager.remove(entityManager.merge(u));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void removeInscription(Establishment u) {
		entityManager.remove(entityManager.merge(u));

	}

	@Override
	public Establishment findInscriptionById(int idEstablishment) {
		Establishment univ = null;
		try {
			univ = entityManager.find(Establishment.class, idEstablishment);

		} catch (Exception e) {

		}
		return univ;
	}

	
	@Override
	public User findUserId(int idd) {
		User user = entityManager.find(User.class, idd);
		return user;
	}
	
	@Override
	public University findUniversityId(int idd) {
		University univ = entityManager.find(University.class, idd);
		return univ;
	}


	@Override
	public List<Establishment> findAll() {
		List<Establishment> univs = new ArrayList<>();
		Query query = entityManager.createQuery("select u from Establishment u");
		return query.getResultList();
	}

	@Override
	public Boolean removeInscriptionById(int idEstablishment) {
		Establishment univ = new Establishment();
		try {
			univ = entityManager.find(Establishment.class, idEstablishment);
			entityManager.remove(entityManager.merge(univ));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Boolean createInscription(Establishment est) {
		Boolean b = false;
		try {
			entityManager.persist(est);

			b = true;

		} catch (Exception e) {

		}

		return b;
	}

}
