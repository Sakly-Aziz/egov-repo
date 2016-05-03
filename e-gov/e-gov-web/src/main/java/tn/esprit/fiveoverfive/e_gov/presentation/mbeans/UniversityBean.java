package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;

import java.io.FileInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;



import egov.entities.University;
import egov.services.interfaces.UniversityManagementLocal;

@ManagedBean
@RequestScoped
public class UniversityBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<University> universities = new ArrayList<>();
	private University universitySelected = new University();
	private Boolean visible = false;

	private String type;


	

	@EJB
	private UniversityManagementLocal universityManagementLocal;

	public void select(University university) {
		visible = true;
		universitySelected = university;
	}

	public String doDelete() {
		universityManagementLocal.remove(universitySelected);
		universitySelected = new University();
		visible = false;
		return "/pages/universityManagement/universityManagement?faces-redirect=true";
	}


	public String cancel() {
		visible = false;
		return "";
	}

	public String show() {
		universitySelected = new University();
		visible = true;
		return "";
	}

	public List<University> getUniversities() {
		universities = universityManagementLocal.findAll();
		return universities;
	}
	
	
	public String Pie()
	{
			
		return  "/pages/universityManagement/animate?faces-redirect=true";
	}

	public void setUniversities(List<University> universities) {
		this.universities = universities;
	}

	public University getUniversitySelected() {
		return universitySelected;
	}

	public void setUniversitySelected(University universitySelected) {
		this.universitySelected = universitySelected;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	


	

	public UniversityManagementLocal getUniversityManagementLocal() {
		return universityManagementLocal;
	}

	public void setUniversityManagementLocal(UniversityManagementLocal universityManagementLocal) {
		this.universityManagementLocal = universityManagementLocal;
	}

	public String doAddUniviersity() {
		universityManagementLocal.update(universitySelected);
		return "";
	}
	

}
