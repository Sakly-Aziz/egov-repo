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
	

	}

}