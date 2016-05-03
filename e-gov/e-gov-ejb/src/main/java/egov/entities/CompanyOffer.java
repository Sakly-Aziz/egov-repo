package egov.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: CompanyOffer
 *
 */
@Entity

public class CompanyOffer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String description;
	private Double lat;
	private Double longitude;
	
	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public List<JobRequest> getJobRequests() {
		return jobRequests;
	}

	public void setJobRequests(List<JobRequest> jobRequests) {
		this.jobRequests = jobRequests;
	}

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Company company;

	@OneToMany(mappedBy = "companyOffer")
	private List<JobRequest> jobRequests;

	public CompanyOffer() {
		super();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
