package egov.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
	@NamedQuery(name="findAccountByUser",query="select c from Account c where c.user.idUser=:var")
})
public class Account implements Serializable {
	@Id
	
	private int num;

	private float ammount;
	@ManyToOne(cascade=CascadeType.PERSIST)

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public float getAmmount() {
		return ammount;
	}

	public void setAmmount(float ammount) {
		this.ammount = ammount;
	}

	public Account(float ammount) {
		super();
		
		this.ammount = ammount;

	}

	public Account() {
		super();
	}

}
