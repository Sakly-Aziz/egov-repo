 package egov.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import egov.entities.Car;
import egov.entities.Constructor;
import egov.entities.User;
import egov.services.interfaces.ICarManagementLocal;
import egov.services.interfaces.ICarManagementRemote;




@Stateless
public class CarManagement implements ICarManagementRemote,ICarManagementLocal {
	@PersistenceContext
	EntityManager Us;

	public Boolean addCar(Car c) {

		try {
			Us.persist(c);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public void flush() {
		Us.flush();
	}

	public Boolean update(Car u) {

		try {
			
			Us.merge(u);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public Boolean remove(Car c) {
		try {
			Us.remove(Us.merge(c));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public Car findCarByNumIm(int numImmatriculation) {
		Car car = null;
		try {
			car = Us.find(Car.class, numImmatriculation);

		} catch (Exception e) {

		}
		return car;
	}

	public List<Car> findAll() {
		List<Car>  cars = new ArrayList<>();
		Query query = Us.createQuery("select u from Car u");
		return query.getResultList();
	}

	
	

	public List<Car> findAllCarByIdUser( User u)
	{
		
		TypedQuery<Car> query =  Us.createNamedQuery("findCaroByUser", Car.class);
		query.setParameter("var", u.getIdUser());
		List<Car> cars= query.getResultList();
		return cars;
		
		
		
	}
	
	public Boolean removeCarByNum(int numImmatriculation){
	Car car=new Car();
	try {
		car = Us.find(Car.class,numImmatriculation);
		Us.remove(Us.merge(car));
		return true;
	} catch (Exception e) {
		return false;
	}

}
	
	public void affecterCarUser(Car c , User u)
	{
		c=Us.find(Car.class, c.getNumImmatriculation());
		u=Us.find(User.class, u.getIdUser());
		List<Car> cars=new ArrayList<>();
		
		if(u.getCars()!=null)
		{
			for (int i = 0; i < u.getCars().size(); i++) {
				cars.add(u.getCars().get(i));
			}
		}
		
		
		
		
		c.setUser(u);
		Us.merge(c);
		cars.add(c);
		u.setCars(cars);
		Us.merge(u);
		
	}

	@Override
	public List<Car> findAllCarByConstructor(Constructor c) {
		String req="select p from Car p where p.constructor like :n";
		List<Car> list = null;
		try{
		Query query = Us.createQuery(req).setParameter("n", c);
		list = query.getResultList();
		} catch(NoResultException ex){
			System.out.println("no result found for query");
		}
		return list;
	}

	@Override
	public void affecterCarConstructeur(Car car, Constructor constructor) {
		car=Us.find(Car.class, car.getImmatriculation());
		constructor=Us.find(Constructor.class, constructor.getId());
		List<Car> cars=new ArrayList<>();
		cars=constructor.getCars();
		
		
		car.setConstructor(constructor);
		Us.merge(car);
		cars.add(car);
		constructor.setCars(cars);
		Us.merge(constructor);
	}

	@Override
	public List<Car> findAllCarSelled(Constructor constructor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> findAllCarNotSelled(boolean test) {
		String req="select p from Car p where p.selled = :n";
		List<Car> list = null;
		try{
		Query query = Us.createQuery(req).setParameter("n", test);
		list = query.getResultList();
		} catch(NoResultException ex){
			System.out.println("no result found for query");
		}
		return list;
	}

	@Override
	public void BuyCar(Car car, User user) {
		
		
		
		
	}
	
	
	
}


