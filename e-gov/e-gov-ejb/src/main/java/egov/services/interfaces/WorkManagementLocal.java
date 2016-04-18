package egov.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import egov.entities.Work;

@Local
public interface WorkManagementLocal {
	Boolean CreateWork(Integer userId, Integer companyId);

	List<Work> findAllWorks();

}
