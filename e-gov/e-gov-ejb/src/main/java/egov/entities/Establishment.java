package egov.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Establishment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EstablishmentPk pk;
	private String level;

	private float fees;

	@JoinColumn(name = "idUser", insertable = false, updatable = false)
	@ManyToOne
	private User user;
	@JoinColumn(name = "nameUniversity", insertable = false, updatable = false)
	@ManyToOne
	private University university;

	public Establishment(String level, float fees, User user, University university) {
		super();
		this.level = level;
		this.fees = fees;
		this.user = user;
		this.university = university;
		this.pk = new EstablishmentPk(user.getIdUser(), university.getIdUniversity());
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public float getFees() {
		return fees;
	}

	public void setFees(float fees) {
		this.fees = fees;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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