package egov.services.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import egov.entities.Company;
import egov.entities.CompanyOffer;
import egov.entities.JobRequest;
import egov.entities.User;
import egov.services.interfaces.CompanyOfferManagementLocal;
import egov.services.interfaces.CompanyOfferManagementRemote;

/**
 * Session Bean implementation class CompanyOfferManagement
 */
@Stateless
public class CompanyOfferManagement implements CompanyOfferManagementRemote, CompanyOfferManagementLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public CompanyOfferManagement() {
	}

	@Override
	public List<CompanyOffer> findAllCompanyOffers() {
		return entityManager.createQuery("SELECT c FROM CompanyOffer c", CompanyOffer.class).getResultList();
	}

	@Override
	public Boolean createCompanyOffer(Integer companyId, CompanyOffer companyOffer) {
		Boolean b = false;
		try {
			Company company = entityManager.find(Company.class, companyId);
			companyOffer.setCompany(company);
			entityManager.persist(companyOffer);

			b = true;
		} catch (Exception e) {
		}

		return b;
	}

	@Override
	public Boolean createJobRequest(Integer userId, Integer offerId) {
		Boolean b = false;
		try {
			CompanyOffer companyOffer = entityManager.find(CompanyOffer.class, offerId);
			User user                 = entityManager.find(User.class, userId);
			JobRequest jobRequest = new JobRequest();
			jobRequest.setDateOfRequest(new Date());

			jobRequest.setUser(user);
			jobRequest.setCompanyOffer(companyOffer);

			entityManager.persist(jobRequest);

			b = true;

		} catch (Exception e) {

		}

		return b;
	}

	@Override
	public Boolean removeCompanyOfferById(Integer offerId) {
		CompanyOffer companyOffer = new CompanyOffer();
		try {
			companyOffer = entityManager.find(CompanyOffer.class, offerId);

			entityManager.remove(entityManager.merge(companyOffer));
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public Boolean remove(CompanyOffer u) {
		try {
			entityManager.remove(entityManager.merge(u));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public CompanyOffer findCompanyOfferById(Integer offerId) {
		CompanyOffer companyOffer = null;
		try {

			companyOffer = entityManager.find(CompanyOffer.class, offerId);
		} catch (Exception e) {

		}

		return companyOffer;
	}

	@Override
	public Boolean update(CompanyOffer u) {
		try {
			entityManager.merge(u);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
