package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import egov.entities.Admin;
import egov.entities.Citizen;
import egov.services.interfaces.IUserMangementLocal;

@ManagedBean
@ViewScoped
public class Authentification {
	private String login;
	private String password;

	@EJB
	IUserMangementLocal service;
	private String user_type = "";

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String Login() {
		if (service.authentificate(login, password) instanceof Admin) {
			setUser_type("admin");
			return "/pages/admin/home?faces-redirect=true";
		} else if (service.authentificate(login, password) instanceof Citizen) {
			setUser_type("citizen");
			return "/pages/citizen/citizen?faces-redirect=true";
		} else {
			FacesMessage message = new FacesMessage("ERROR", "Login ou pwd incorrect");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return null;

		}
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

}