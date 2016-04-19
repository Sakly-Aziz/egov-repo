package egov.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import egov.entities.*;

@Local
public interface InscriptionManagementLocal {

	Boolean addInscription(Establishment u );

	Boolean update(Establishment u);

	void flush();

	Boolean remove(Establishment u);

	void removeInscription(Establishment u);

	List<Establishment> findAll();

	Establishment findInscriptionById(int idEstablishment);

	Boolean removeInscriptionById(int idEstablishment);
	Boolean createInscription(Establishment est);
	User findUserId(int idd);
	University findUniversityId(int idd);
}