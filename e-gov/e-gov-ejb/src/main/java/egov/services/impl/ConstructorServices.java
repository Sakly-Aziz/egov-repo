package egov.services.impl;

import egov.entities.Car;
import egov.entities.Constructor;
import egov.services.interfaces.ConstructorServicesLocal;
import egov.services.interfaces.ConstructorServicesRemote;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class ConstructorServices implements ConstructorServicesRemote, ConstructorServicesLocal {

	@PersistenceContext
	EntityManager  EntityManager ;

	@Override
	public Boolean addConstructor(Constructor c) {

			try {
				EntityManager.persist(c);
				return true;
			} catch (Exception e) {
				return false;
			}


			

}

	@Override
	public List<Constructor> findAll() {

		
			List<Car>  cars = new ArrayList<>();
			Query query = EntityManager.createQuery("select u from Constructor u");
			return query.getResultList();
		}


}