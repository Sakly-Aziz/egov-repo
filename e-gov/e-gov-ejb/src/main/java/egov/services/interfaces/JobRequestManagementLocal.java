package egov.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import egov.entities.JobRequest;

@Local
public interface JobRequestManagementLocal {
	List<JobRequest> findAllJobRequests();
	 List<JobRequest> findAllJobRequestsById(int idcc);
}
