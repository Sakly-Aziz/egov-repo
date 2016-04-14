package egov.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import egov.entities.CompanyOffer;

@Local
public interface CompanyOfferManagementLocal {
	List<CompanyOffer> findAllCompanyOffers();

	Boolean createCompanyOffer(Integer companyId, CompanyOffer companyOffer);

	Boolean createJobRequest(Integer userId, Integer offerId);
}
