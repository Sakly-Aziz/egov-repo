package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import egov.entities.Car;
import egov.entities.Constructor;
import egov.services.interfaces.ConstructorServicesLocal;;

@ManagedBean
@SessionScoped
public class ConstructorBean {
	@EJB
	private ConstructorServicesLocal constructorServicesLocal;
	
	private List<Constructor> constructors ;
	private Constructor constructor ;
	private Constructor constructorSelected = new Constructor();
	private boolean displayForm;
	
	@PostConstruct
	public void init() {
		setConstructor(new Constructor());
		constructors = constructorServicesLocal.findAll();
		
		
	}

	public List<Constructor> getConstructors() {
		constructors = constructorServicesLocal.findAll();
		return constructors;
	}
	
	public Constructor getConstructor() {
		return constructor ;
	}
	public void setConstructor(Constructor constructor) {
		this.constructor = constructor;
	}
	public void doNew(){
	
		constructor=new Constructor();
	}
		public void doSave() {
			constructorServicesLocal.addConstructor(constructor);
			init();
		
		}
		public void doSelectConstructor(Constructor c) {
			constructorSelected = c;
		}


		public Constructor getConstructorSelected() {
			return constructorSelected;
		}

		public void setConstructorSelected(Constructor constructorSelected) {
			this.constructorSelected = constructorSelected;
		}
	
		


		
		
	

	

}
