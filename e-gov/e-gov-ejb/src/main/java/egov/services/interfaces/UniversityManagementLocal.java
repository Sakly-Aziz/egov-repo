package egov.services.interfaces;
import java.util.List;

import javax.ejb.Local;

import egov.entities.University;

@Local
public interface UniversityManagementLocal {

	Boolean addUniversity(University u);

	Boolean update(University u);

	void flush();

	Boolean remove(University u);

	void removeUniversity(University u);

	List<University> findAll();

	University findUniversityById(int idUniversity);

	Boolean removeUniversityById(int idUniversity);
	List<String> chercherEsprit();
	List<String> chercherTime();
	

}
