package egov.services.interfaces;

import java.util.List;

import egov.entities.Intervention;

public interface IInterventionManagementLocal {

	List<Intervention> findAll();



	void flush();

	

	Boolean removeIntervention(Intervention i);

	Boolean updateIntervention(Intervention i);

	Boolean addIntervention(Intervention i);

}
