package egov.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import egov.entities.JobRequest;
import egov.services.interfaces.JobRequestManagementLocal;
import egov.services.interfaces.JobRequestManagementRemote;

@Stateless
public class JobRequestManagement implements JobRequestManagementRemote, JobRequestManagementLocal {
	@PersistenceContext
	private EntityManager entityManager;

	public JobRequestManagement() {

	}

	@Override
	public List<JobRequest> findAllJobRequests() {

		return entityManager.createQuery("SELECT c FROM JobRequest c", JobRequest.class).getResultList();
	}
	
	@Override
	public List<JobRequest> findAllJobRequestsById(int idcc) {
		List<JobRequest>  jobs = null;
		Query query = entityManager.createQuery("SELECT c FROM JobRequest c where c.user.idUser=:idvv");
		query.setParameter("idvv", idcc);

		jobs = query.getResultList();
		return jobs;
	}


}
