package egov.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import egov.entities.Establishment;

@Local
public interface InscriptionManagementLocal {

	Boolean addInscription(Establishment u);

	Boolean update(Establishment u);

	void flush();

	Boolean remove(Establishment u);

	void removeInscription(Establishment u);

	List<Establishment> findAll();

	Establishment findInscriptionById(int idEstablishment);

	Boolean removeInscriptionById(int idEstablishment);
}