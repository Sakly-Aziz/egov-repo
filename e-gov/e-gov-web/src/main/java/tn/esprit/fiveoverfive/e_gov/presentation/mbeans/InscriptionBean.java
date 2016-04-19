package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import egov.entities.Establishment;
import egov.services.interfaces.InscriptionManagementLocal;

@ManagedBean
@ViewScoped
public class InscriptionBean {
	private List<Establishment> universities = new ArrayList<>();
	private Establishment EstablishementSelected = new Establishment();
	private Boolean visible = false;

	@EJB
	private InscriptionManagementLocal InscriptionManagementLocal;

	public void select(Establishment university) {
		visible = true;
		EstablishementSelected = university;
	}

	public String doDelete() {
		InscriptionManagementLocal.remove(EstablishementSelected);
		EstablishementSelected = new Establishment();
		visible = false;
		return "";
	}

	public String doSaveOrUpdate() {
		InscriptionManagementLocal.update(EstablishementSelected);
		EstablishementSelected = new Establishment();
		visible = false;
		return "";
	}

	public String cancel() {
		visible = false;
		return "";
	}

	public String show() {
		EstablishementSelected = new Establishment();
		visible = true;
		return "";
	}

	public List<Establishment> getUniversities() {
		universities = InscriptionManagementLocal.findAll();
		return universities;
	}

	public void setUniversities(List<Establishment> universities) {
		this.universities = universities;
	}

	public Establishment getUniversitySelected() {
		return EstablishementSelected;
	}

	public void setUniversitySelected(Establishment EstablishementSelected) {
		this.EstablishementSelected = EstablishementSelected;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
}
