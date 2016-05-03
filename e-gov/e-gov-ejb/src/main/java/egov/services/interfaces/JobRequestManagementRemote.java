package egov.services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import egov.entities.JobRequest;

@Remote
public interface JobRequestManagementRemote {
	List<JobRequest> findAllJobRequests();
	 List<JobRequest> findAllJobRequestsById(int idcc);
}
