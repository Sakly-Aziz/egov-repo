package egov.services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import egov.entities.Work;

@Remote
public interface WorkManagementRemote {
	Boolean CreateWork(Integer userId, Integer companyId);

	List<Work> findAllWorks();
}
