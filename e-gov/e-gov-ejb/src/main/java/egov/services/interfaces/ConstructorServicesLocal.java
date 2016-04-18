package egov.services.interfaces;

import java.util.List;

import javax.ejb.Local;


import egov.entities.Constructor;


@Local
public interface ConstructorServicesLocal {
	Boolean addConstructor(Constructor c);
	List<Constructor> findAll();
	

}
