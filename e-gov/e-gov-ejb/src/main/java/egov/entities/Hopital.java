package egov.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hopital implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	
	private int numHopital;

	private String name;
	private String adresse;

	@OneToMany(mappedBy = "hopital", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Intervention> interventions;

	public List<Intervention> getInterventions() {
		return interventions;
	}

	public int getNumHopital() {
		return numHopital;
	}

	public void setNumHopital(int numHopital) {
		this.numHopital = numHopital;
	}

	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}

	public Hopital() {
		super();
	}

	public Hopital(String name, String adresse) {
		super();
	
		this.name = name;
		this.adresse = adresse;
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

}