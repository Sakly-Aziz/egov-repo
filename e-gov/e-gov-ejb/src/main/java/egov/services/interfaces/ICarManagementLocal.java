package egov.services.interfaces;
import java.util.List;

import javax.ejb.Local;

import egov.entities.Car;
import egov.entities.Constructor;
import egov.entities.User;

@Local
public interface ICarManagementLocal {
	Boolean addCar(Car c);

	Boolean update(Car c);

	void flush();

	Boolean remove(Car c);

	List<Car> findAll();

	Car findCarByNumIm(int numImmatriculation);

	List<Car> findAllCarByIdUser(User u);

	Boolean removeCarByNum(int numImmatriculation);

	void affecterCarUser(Car c, User u);
	List<Car> findAllCarByConstructor(Constructor c);
	void affecterCarConstructeur(Car car,Constructor constructor);
	List<Car> findAllCarSelled(Constructor constructor);

	List<Car> findAllCarNotSelled(boolean test);
	void BuyCar(Car car,User user);

}
