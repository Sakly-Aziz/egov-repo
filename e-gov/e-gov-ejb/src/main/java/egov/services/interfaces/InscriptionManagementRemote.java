package egov.services.interfaces;

import java.util.List;

import egov.entities.Establishment;;

public interface InscriptionManagementRemote {

	Boolean addInscription(Establishment u);

	Boolean update(Establishment u);

	void flush();

	Boolean remove(Establishment u);

	void removeInscription(Establishment u);

	List<Establishment> findAll();

	Establishment findInscriptionById(int idEstablishment);

	Boolean removeInscriptionById(int idEstablishment);
}
