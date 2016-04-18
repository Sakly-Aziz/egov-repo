package egov.services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import egov.entities.Car;
import egov.entities.Constructor;

@Remote
public interface ConstructorServicesRemote {
	Boolean addConstructor(Constructor c);
	List<Constructor> findAll();
}
