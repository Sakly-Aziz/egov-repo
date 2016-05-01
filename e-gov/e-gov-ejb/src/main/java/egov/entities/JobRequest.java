package egov.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: JobRequest
 *
 */
@Entity

public class JobRequest implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date DateOfRequest;
	
	
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private User user;
	

	@ManyToOne
	private CompanyOffer companyOffer;

	public JobRequest() {
		super();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateOfRequest() {
		return this.DateOfRequest;
	}

	public void setDateOfRequest(Date DateOfRequest) {
		this.DateOfRequest = DateOfRequest;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CompanyOffer getCompanyOffer() {
		return companyOffer;
	}

	public void setCompanyOffer(CompanyOffer companyOffer) {
		this.companyOffer = companyOffer;
	}

}
