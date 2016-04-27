package egov.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="findCaroByUser",query="select c from Car c where c.user.idUser=:var")
})
public class Car implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int numImmatriculation;
	private String color;
	private String type;
	private String category;
	@Column(name = "Selled", columnDefinition = "boolean default false", nullable = true)
	private boolean selled=false;
	private int prix;
	

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	@ManyToOne(cascade=CascadeType.PERSIST)
	private User user;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Constructor constructor;
	public int getImmatriculation() {
		return numImmatriculation;
	}

	public void setImmatriculation(int numImmatriculation) {
		this.numImmatriculation = numImmatriculation;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumImmatriculation() {
		return numImmatriculation;
	}
	

	@Override
	public String toString() {
		return "Car [numImmatriculation=" + numImmatriculation + ", color=" + color + ", type=" + type + ", category="
				+ category + ", user=" + user + "]";
	}

	public void setNumImmatriculation(int numImmatriculation) {
		this.numImmatriculation = numImmatriculation;
	}

	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	@ManyToOne
	public Constructor getConstructor() {
		return constructor;
	}

	public void setConstructor(Constructor constructor) {
		this.constructor = constructor;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
	public Car(int numImmatriculation, String color, String type, String category, String constructor, User user) {
		super();
		this.numImmatriculation = numImmatriculation;
		this.color = color;
		this.type = type;
		this.category = category;
		this.user = user;
	}

	public Car() {
		super();
	}

	public boolean isSelled() {
		return selled;
	}

	public void setSelled(boolean selled) {
		this.selled = selled;
	}

}
