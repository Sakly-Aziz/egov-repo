package egov.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Intervention implements Serializable {
	@Id
	private int idI;
	private String name;
	private String description;

	@OneToMany(mappedBy = "intervention", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Detail> detail;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Hopital hopital;

	public Hopital getHopital() {
		return hopital;
	}
	public void setHopital(Hopital hopital) {
		this.hopital = hopital;
	}
	public int getIdI() {
		return idI;
	}
	public void setIdI(int idI) {
		this.idI = idI;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Detail> getDetail() {
		return detail;
	}
	public void setDetail(List<Detail> detail) {
		this.detail = detail;
	}
	public Intervention() {
		super();
	}

	public Intervention(int idI, String name, String description, List<Detail> detail, Hopital hopital) {
		super();
		this.idI = idI;
		this.name = name;
		this.description = description;
		this.detail = detail;
		this.hopital = hopital;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	
	

}
