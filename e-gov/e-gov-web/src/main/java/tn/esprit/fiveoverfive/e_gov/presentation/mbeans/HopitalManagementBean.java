package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import egov.entities.Hopital;
import egov.services.interfaces.IHopitalManagement;


@ManagedBean
@SessionScoped
public class HopitalManagementBean {
	
		@EJB
		private IHopitalManagement iHopitalManagement;

		private List<Hopital> hopitals = new ArrayList<>();
		
		private int numHopital;
		private String name;
		private String adresse;
		
		private boolean display_add = false;
		
		private boolean displayUpdate = false;

		
		private Hopital hopital=new Hopital() ;
		private Hopital hopitalselected;

		
	

		public String doAddHopital() {
			
			iHopitalManagement.addHopital(hopital);
			return "/pages/hopitalManagement/listHopital?faces-redirect=true";
		}

		public String doDeleteHopital(Hopital hopitalselected) {
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


		
		
@PostConstruct
public void init() {
	

			

}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAdresse() {
	return adresse;
}

public void setAdresse(String adresse) {
	this.adresse = adresse;
}

public int getNumHopital() {
	return numHopital;
}

public void setNumHopital(int numHopital) {
	this.numHopital = numHopital;
}

public boolean isDisplay_add() {
	return display_add;
}

public void setDisplay_add(boolean display_add) {
	this.display_add = display_add;
}

public boolean isDisplayUpdate() {
	return displayUpdate;
}

public void setDisplayUpdate(boolean displayUpdate) {
	this.displayUpdate = displayUpdate;
}
	}




