package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import egov.entities.Intervention;

import egov.services.interfaces.IInterventionManagementLocal;

@ManagedBean
@SessionScoped
public class InterventionManagementBean {
	@EJB
	private IInterventionManagementLocal iInterventionManagementLocal;
	
	private List<Intervention> interventions = new ArrayList<>();
	private Intervention intervention = new Intervention();
	private Intervention interventionSelected = new Intervention();
	
	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}
	public Intervention getIntervention() {
		return intervention;
	}
	public void setIntervention(Intervention intervention) {
		this.intervention = intervention;
	}
	public Intervention getInterventionSelected() {
		return interventionSelected;
	}
	public void setInterventionSelected(Intervention interventionSelected) {
		this.interventionSelected = interventionSelected;
	}

	public String doAddIntervention() {
		iInterventionManagementLocal.addIntervention(intervention);
		return "/pages/interventionManagement/listInterventions?faces-redirect=true";
	}

	public String doDeleteIntervention(Intervention interventionSelected) {
		iInterventionManagementLocal.removeIntervention(interventionSelected);
		return "/pages/interventionManagement/listInterventions?faces-redirect=true";
	}

	public String doUpdateIntervention() {
		iInterventionManagementLocal.updateIntervention(interventionSelected);
		return "/pages/interventionManagement/listInterventions?faces-redirect=true";
	}

	public void doSelectIntervention(Intervention u) {
		interventionSelected = u;
	}

	public List<Intervention> getInterventions() {
		interventions = iInterventionManagementLocal.findAll();
		return interventions;
	}

}
