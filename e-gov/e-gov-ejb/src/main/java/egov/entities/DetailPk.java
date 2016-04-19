package egov.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DetailPk  implements Serializable{
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idI;
		result = prime * result + idUser;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetailPk other = (DetailPk) obj;
		if (idI != other.idI)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}
	public DetailPk() {
		super();
	}
	public DetailPk(int idUser, int idI) {
		super();
		this.idUser = idUser;
		this.idI = idI;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdI() {
		return idI;
	}
	public void setIdI(int idI) {
		this.idI = idI;
	}
	private int idUser;
	private int idI;
	

}
