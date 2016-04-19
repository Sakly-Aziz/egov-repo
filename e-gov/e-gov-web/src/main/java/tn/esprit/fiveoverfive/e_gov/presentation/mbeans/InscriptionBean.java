package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import egov.entities.Establishment;
import egov.entities.University;
import egov.entities.User;
import egov.services.interfaces.InscriptionManagementLocal;

@ManagedBean(name="inscriptionBean")
@RequestScoped
public class InscriptionBean {
	private List<Establishment> ests = new ArrayList<>();
	private Establishment EstablishementSelected = new Establishment();
	private Establishment Establishement1 = new Establishment();
	private Integer idUser ; 
	private Integer idUniversity; 
	private float fees;
	private String level;
	private Establishment est ;

	private University university = new University();
	private User user = new User();

	private Boolean visible = false;
	

	@EJB
	private InscriptionManagementLocal InscriptionManagementLocal;
	
	
	@PostConstruct
	public void init(){
	//	setEst(new Establishment());
	}

	public void select(Establishment university) {
		visible = true;
		EstablishementSelected = university;
	}

	public String doDelete() {
		InscriptionManagementLocal.remove(EstablishementSelected);
		EstablishementSelected = new Establishment();
		visible = false;
		return "";
	}

	public String doSaveOrUpdate() {
		Establishment est = new Establishment();
        User user = InscriptionManagementLocal.findUserId(3);
        University univ = InscriptionManagementLocal.findUniversityId(1);
        System.out.println(univ.getNameUniversity());
        System.out.println("momo");
        est.setUser(user);
        est.setUniversity(univ);
		est.setFees(fees);
		est.setLevel(level);
		InscriptionManagementLocal.addInscription(est);
		System.out.println("toto");
		System.out.println(est.getFees());
		System.out.println(est.getUser().getFirstName());
		System.out.println("soso");
		return "aaaaa";
	}

	public String cancel() {
		visible = false;
		return "";
	}

	public String show() {
		EstablishementSelected = new Establishment();
		visible = true;
		return "";
	}



	public List<Establishment> getEsts() {
		ests = InscriptionManagementLocal.findAll();
		return ests;
	}

	public void setEsts(List<Establishment> ests) {
		this.ests = ests;
	}


	public Establishment getEstablishmentSelected() {
		return EstablishementSelected;
	}

	public void setEstablishmentSelected(Establishment EstablishementSelected) {
		this.EstablishementSelected = EstablishementSelected;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public float getFees() {
		return fees;
	}

	public void setFees(float fees) {
		this.fees = fees;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Establishment getEst() {
		return est;
	}

	public void setEst(Establishment est) {
		this.est = est;
	}

	public Establishment getEstablishementSelected() {
		return EstablishementSelected;
	}

	public void setEstablishementSelected(Establishment establishementSelected) {
		EstablishementSelected = establishementSelected;
	}

	public Establishment getEstablishement1() {
		return Establishement1;
	}

	public void setEstablishement1(Establishment establishement1) {
		Establishement1 = establishement1;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getIdUniversity() {
		return idUniversity;
	}

	public void setIdUniversity(Integer idUniversity) {
		this.idUniversity = idUniversity;
	}

	public InscriptionManagementLocal getInscriptionManagementLocal() {
		return InscriptionManagementLocal;
	}

	public void setInscriptionManagementLocal(InscriptionManagementLocal inscriptionManagementLocal) {
		InscriptionManagementLocal = inscriptionManagementLocal;
	}
	
	
}
