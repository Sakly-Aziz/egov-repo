package egov.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import egov.entities.Company;

@Local
public interface ICompanyManagementLocal {
	Boolean addCompany(Company c);

	Boolean update(Company c);

	void flush();

	Boolean remove(Company c);

	Boolean removeCompanyById(int idCompany);

	List<Company> findAll();

	Company findCompanyById(int id);

	Company findcomanyByIdCompany(Integer idCompany);

}
