package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import egov.entities.Car;
import egov.entities.Constructor;
import egov.entities.User;
import egov.services.interfaces.ConstructorServicesLocal;
import egov.services.interfaces.ICarManagementLocal;
import egov.services.interfaces.IUserMangementLocal;

@ManagedBean
@ViewScoped
public class UserCarBean {
	@EJB
	private ICarManagementLocal iCarManagementLocal;
	@EJB 
	private ConstructorServicesLocal constructorServicesLocal;
	
	@EJB
	IUserMangementLocal iuserlIUserMangementLocal;
	private List<Car> cars;
	private Car car = new Car();
	private Car carSelected = new Car();
	
	@PostConstruct
	public void init() {
		
		cars=iCarManagementLocal.findAllCarNotSelled(false);
				
	}
	
	public void buyCar(Car car)
	{
		User u=new User();
		System.out.println("aaaaaaaaaaaa");
		u=iuserlIUserMangementLocal.findUserById(22);
		System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		System.out.println(u.getIdUser());
		System.out.println(car.getNumImmatriculation());
		
 iCarManagementLocal.affecterCarUser(car,u);
		

		
		
		
		
		}
	
	
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Car getCarSelected() {
		return carSelected;
	}
	public void setCarSelected(Car carSelected) {
		this.carSelected = carSelected;
	}


	
}
