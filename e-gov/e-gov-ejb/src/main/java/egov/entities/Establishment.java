package egov.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Establishment implements Serializable {
	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.AUTO)

	private EstablishmentPk pk;
	private int idEstablishment;

	private String level;
	private Date inscriptionDate;
	private int inscriptionNumber;
	private float fees;

	@JoinColumn(name = "idUser", insertable = false, updatable = false)
	@ManyToOne
	private User user1;
	@JoinColumn(name = "nameUniversity", insertable = false, updatable = false)
	@ManyToOne
	private University university;

	public Establishment(String level, Date inscriptionDate, int inscriptionNumber, float fees, User user1,
			University university) {
		super();
		this.level = level;
		this.inscriptionDate = inscriptionDate;
		this.inscriptionNumber = inscriptionNumber;
		this.fees = fees;
		this.user1 = user1;
		this.university = university;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Date getInscriptionDate() {
		return inscriptionDate;
	}

	public void setInscriptionDate(Date inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}

	public int getInscriptionNumber() {
		return inscriptionNumber;
	}

	public void setInscriptionNumber(int inscriptionNumber) {
		this.inscriptionNumber = inscriptionNumber;
	}

	public float getFees() {
		return fees;
	}

	public void setFees(float fees) {
		this.fees = fees;
	}

	public User getUser() {
		return user1;
	}

	public void setUser(User user) {
		this.user1 = user1;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Establishment() {
		super();
	}

}
