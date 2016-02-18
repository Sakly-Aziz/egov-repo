package egov.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Kase implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCase;
	private String nameCase;
	private String judgment;
	private Date dateCase;
	@ManyToOne
	private User user;
	public int getIdCase() {
		return idCase;
	}
	public void setIdCase(int idCase) {
		this.idCase = idCase;
	}
	public String getNameCase() {
		return nameCase;
	}
	public void setNameCase(String nameCase) {
		this.nameCase = nameCase;
	}
	public String getJudgment() {
		return judgment;
	}
	public void setJudgment(String judgment) {
		this.judgment = judgment;
	}
	public Date getDateCase() {
		return dateCase;
	}
	public void setDateCase(Date dateCase) {
		this.dateCase = dateCase;
	}
	public Kase(int idCase, String nameCase, String judgment, Date dateCase) {
		super();
		this.idCase = idCase;
		this.nameCase = nameCase;
		this.judgment = judgment;
		this.dateCase = dateCase;
	}
	public Kase() {
		super();
	}
	
	
	

}