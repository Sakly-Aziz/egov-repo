package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import egov.entities.CompanyOffer;
import egov.services.interfaces.CompanyOfferManagementLocal;

@ManagedBean
@RequestScoped
public class CompanyOfferBean {
	private List<CompanyOffer> companyOffers = new ArrayList<>();
	private CompanyOffer companyOffer = new CompanyOffer();
	private CompanyOffer companyOfferSelected = new CompanyOffer();
	private Boolean visible = false;
	private Integer companyId;

	@EJB
	private CompanyOfferManagementLocal companyOfferManagementLocal;

	public void select(CompanyOffer companyOffer) {
		visible = true;
		companyOfferSelected = companyOffer;
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

}
