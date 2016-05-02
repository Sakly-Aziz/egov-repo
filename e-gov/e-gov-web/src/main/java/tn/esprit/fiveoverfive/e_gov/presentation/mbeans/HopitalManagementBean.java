package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import egov.entities.Hopital;
import egov.services.interfaces.IHopitalManagement;

@ManagedBean
@ViewScoped
public class HopitalManagementBean {
	
		@EJB
		private IHopitalManagement iHopitalManagement;

		private List<Hopital> hopitals = new ArrayList<>();
		private Hopital hopital ;
		private Hopital hopitalselected = new Hopital();
		private Hopital a;
		

		public String doAddHopital() {
			iHopitalManagement.addHopital(hopital);
			return "/pages/hopitalManagement/listHopital?faces-redirect=true";
		}

		public String doDeleteCar(Hopital hopitalselected) {
			iHopitalManagement.removeHopital(hopitalselected);
			return "/pages/hopitalManagement/listHopital?faces-redirect=true";
		}

		public String doUpdateHopital() {
			iHopitalManagement.updateHopital(hopitalselected);
			return "/pages/hopitalManagement/listHopital?faces-redirect=true";
		}

		public void doSelectHopital(Hopital c) {
			hopitalselected = c;
		}

		public List<Hopital> getHopitals() {
			hopitals = iHopitalManagement.findAll();
			return hopitals;
		}

		public void setHopitals(List<Hopital> hopitals) {
			this.hopitals = hopitals;
		}

		public Hopital getHopital() {
			return hopital;
		}

		public void setHopital(Hopital hopital) {
			this.hopital = hopital;
		}

		public Hopital getHopitalSelected() {
			return hopitalselected;
		}

		public void setHopitalSelected(Hopital hopitalSelected) {
			this.hopitalselected = hopitalSelected;
		}

		public Hopital getA() {
			return a;
		}

		public void setA(Hopital a) {
			this.a = a;
		}
		
		
@PostConstruct
public void init() {
	

			

}
	}




