package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.message.Message;

import egov.entities.Admin;
import egov.entities.Citizen;
import egov.entities.User;
import egov.services.interfaces.IUserMangementLocal;


@ManagedBean
@SessionScoped
public class Authentification {

	private String login;
	private String password;
	// models
	private Citizen citizen;
	private Admin admin;
	private User user= new User();
	private String user_type ="";

	// injection
	@EJB
	IUserMangementLocal service;

	// methodes
	
	public String doAddCitizen(){
		service.addUser(citizen);
		return "/greetings?faces-redirect=true";
		
	}
	public String doLogin() {
		String navigateTo = "";
		User userLoggedIn = service.authentificate(login , password );
		if (userLoggedIn != null) {
			if (userLoggedIn instanceof Citizen) {
				user_type="Citizen";
				navigateTo = "/pages/citizen/citizen?faces-redirect=true";
				user = userLoggedIn;
				
			} else if (userLoggedIn instanceof Admin) {
				user_type="admin";
				navigateTo = "/pages/admin/home?faces-redirect=true";
				
			} 
		} else {
			FacesMessage message= new FacesMessage("ERROR", "Login ou password incorrect");
			FacesContext.getCurrentInstance().addMessage(null, message);
			navigateTo = "/public/login.jsf";
		}
		return navigateTo;
	}

	public String doAddAdmin() {
		service.addUser(admin);
		return "/greetings?faces-redirect=true";
	}
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	
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
	

	
	public String  doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/public/login?faces-redirect=true";
		
	}
}