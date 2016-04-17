package egov.utility;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import egov.entities.Admin;
import egov.entities.Citizen;
import egov.entities.University;
import egov.services.interfaces.IUserMangementLocal;
import egov.services.interfaces.UniversityManagementLocal;

/**
 * Session Bean implementation class Util
 */
@Singleton
@LocalBean
@Startup
public class Util {

	@EJB
	private UniversityManagementLocal universityManagementLocal;
	@EJB
	private IUserMangementLocal iUserMangementLocal;

	/**
	 * Default constructor.
	 */
	public Util() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void initDB() {
		University university = new University("ESPRIT", "GHAZELA", 123456);
		University university2 = new University("TIME", "TUNIS", 1234789);

		Citizen citizen = new Citizen();
		citizen.setLogin("c");
		citizen.setPwd("c");
		
		Admin admin1 = new Admin();
		admin1.setLogin("admin");
		admin1.setPwd("admin");
		
		

		universityManagementLocal.addUniversity(university);
		universityManagementLocal.addUniversity(university2);

		iUserMangementLocal.addUser(citizen);
		iUserMangementLocal.addUser(admin1);

	}

}
