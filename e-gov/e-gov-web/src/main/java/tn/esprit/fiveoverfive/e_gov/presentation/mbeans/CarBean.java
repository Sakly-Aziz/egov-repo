package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import egov.entities.Car;
import egov.services.interfaces.ICarManagementLocal;

@ManagedBean
@ViewScoped
public class CarBean {
	@EJB
	private ICarManagementLocal iCarManagementLocal;

	private List<Car> cars = new ArrayList<>();
	private Car car = new Car();
	private Car carSelected = new Car();

	public String doAddCar() {
		iCarManagementLocal.addCar(car);
		return "/pages/carManagement/listCars?faces-redirect=true";
	}

	public String doDeleteCar(Car carSelected) {
		iCarManagementLocal.remove(carSelected);
		return "/pages/carManagement/listCars?faces-redirect=true";
	}

	public String doUpdateCar() {
		iCarManagementLocal.update(carSelected);
		return "/pages/carManagement/listCars?faces-redirect=true";
	}

	public void doSelectCar(Car c) {
		carSelected = c;
	}

	public List<Car> getCars() {
		cars = iCarManagementLocal.findAll();
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

