package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.component.datatable.DataTable;

import egov.entities.CompanyOffer;
import egov.entities.JobRequest;
import egov.services.interfaces.CompanyOfferManagementLocal;

@ManagedBean
@SessionScoped
public class CompanyOfferBean {
	private List<CompanyOffer> companyOffers = new ArrayList<>();
	private CompanyOffer companyOffer = new CompanyOffer();
	private CompanyOffer companyOfferSelected = new CompanyOffer();
	private JobRequest jobRequest = new JobRequest();
	private JobRequest jobRequestSelected = new JobRequest();
	private Boolean visible = false;
	private Integer companyId;
	private Integer userId;
	private Integer offerId;
	private DataTable datatable;
	@EJB
	private CompanyOfferManagementLocal companyOfferManagementLocal;

	public void select(CompanyOffer companyOffer) {
		visible = true;
		companyOfferSelected = companyOffer;
	}

	public void select(JobRequest jobRequest) {
		visible = true;
		jobRequestSelected = jobRequest;
	}

	public JobRequest getJobRequest() {
		return jobRequest;
	}

	public void setJobRequest(JobRequest jobRequest) {
		this.jobRequest = jobRequest;
	}

	public JobRequest getJobRequestSelected() {
		return jobRequestSelected;
	}

	public void setJobRequestSelected(JobRequest jobRequestSelected) {
		this.jobRequestSelected = jobRequestSelected;
	}

	public String doDelete() {
		companyOfferManagementLocal.remove(companyOfferSelected);
		companyOfferSelected = new CompanyOffer();
		visible = false;

		return "";

	}

	public String doSaveOrUpdate() {
		companyOfferManagementLocal.update(companyOfferSelected);
		companyOfferSelected = new CompanyOffer();
		visible = false;
		return "";
	}

	public String doCreateCompanyOffer() {
		companyOfferManagementLocal.createCompanyOffer(companyId, companyOffer);
		return "";
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getOfferId() {
		return offerId;
	}

	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}

	public String doCreateJobRequest(CompanyOffer co) {

		companyOfferManagementLocal.createJobRequest(3, co.getId());
		return "";
	}

	public List<CompanyOffer> getCompanyOffers() {
		companyOffers = companyOfferManagementLocal.findAllCompanyOffers();
		return companyOffers;
	}

	public void setCompanyOffers(List<CompanyOffer> companyOffers) {
		this.companyOffers = companyOffers;
	}

	public CompanyOffer getCompanyOffer() {
		return companyOffer;
	}

	public CompanyOffer getCompanyOfferSelected() {
		return companyOfferSelected;
	}

	public void setCompanyOfferSelected(CompanyOffer companyOfferSelected) {
		this.companyOfferSelected = companyOfferSelected;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public CompanyOfferManagementLocal getCompanyOfferManagementLocal() {
		return companyOfferManagementLocal;
	}

	public void setCompanyOfferManagementLocal(CompanyOfferManagementLocal companyOfferManagementLocal) {
		this.companyOfferManagementLocal = companyOfferManagementLocal;
	}

	public void setCompanyOffer(CompanyOffer companyOffer) {
		this.companyOffer = companyOffer;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public DataTable getDatatable() {
		return datatable;
	}

	public void setDatatable(DataTable datatable) {
		this.datatable = datatable;
	}

}
