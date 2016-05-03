package egov.services.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import egov.entities.Company;
import egov.entities.User;
import egov.entities.Work;
import egov.services.interfaces.WorkManagementLocal;
import egov.services.interfaces.WorkManagementRemote;

@Stateless
public class WorkManagement implements WorkManagementRemote, WorkManagementLocal {
	@PersistenceContext
	private EntityManager entityManager;

	public WorkManagement() {

	}

	@Override
	public Boolean CreateWork(Integer userId, Integer companyId) {

		Boolean b = false;
		try {
			Company company = entityManager.find(Company.class, companyId);
			User user = entityManager.find(User.class, userId);

			Work work = new Work();
			work.setAssignmentDate(new Date());
			work.setDuration(new String());
			work.setJobType(new String());

			work.setUser(user);
			work.setCompany(company);

			entityManager.persist(work);

			b = true;

		} catch (Exception e) {

		}

		return b;

	}

	@Override
	public List<Work> findAllWorks() {
		return entityManager.createQuery("SELECT c FROM Work c", Work.class).getResultList();
	}
}
