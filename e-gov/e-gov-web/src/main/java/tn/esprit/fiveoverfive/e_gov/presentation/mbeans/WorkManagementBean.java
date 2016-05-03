package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import egov.entities.Company;
import egov.entities.Work;
import egov.services.interfaces.WorkManagementLocal;

@ManagedBean
@SessionScoped
public class WorkManagementBean {
	private List<Work> works = new ArrayList<>();
	private Work work = new Work();
	private Work workSelected = new Work();
	private Boolean visible = false;
	@EJB
	private WorkManagementLocal workManagementLocal;

	public void select(Work work) {
		visible = true;
		workSelected = work;
	}

	public String doCreateWork(Company c) {
		workManagementLocal.CreateWork(1, c.getIdCompany());
		return "";
	}

	public List<Work> getWorks() {
		return works;
	}

	public void setWorks(List<Work> works) {
		this.works = works;
	}

	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
	}

	public Work getWorkSelected() {
		return workSelected;
	}

	public void setWorkSelected(Work workSelected) {
		this.workSelected = workSelected;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public WorkManagementLocal getWorkManagementLocal() {
		return workManagementLocal;
	}

	public void setWorkManagementLocal(WorkManagementLocal workManagementLocal) {
		this.workManagementLocal = workManagementLocal;
	}

}
