package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import egov.entities.JobRequest;
import egov.services.interfaces.JobRequestManagementLocal;

@ManagedBean
@SessionScoped
public class JobRequestBean {
	private List<JobRequest> jobRequests = new ArrayList<>();
	private JobRequest jobRequest = new JobRequest();
	private JobRequest jobRequestSelected = new JobRequest();
	private Boolean visible = false;
	@EJB
	private JobRequestManagementLocal jobRequestManagementLocal;

	public void select(JobRequest jobRequest) {
		visible = true;
		jobRequestSelected = jobRequest;
	}

	public List<JobRequest> getJobRequests() {
		return jobRequests;
	}

	public void setJobRequests(List<JobRequest> jobRequests) {
		this.jobRequests = jobRequests;
	}

	public JobRequest getJobRequest() {
		return jobRequest;
	}

	public void setJobRequest(JobRequest jobRequest) {
		this.jobRequest = jobRequest;
	}

	public JobRequest getJobRequestSelected() {
		return jobRequestSelected;
	}

	public void setJobRequestSelected(JobRequest jobRequestSelected) {
		this.jobRequestSelected = jobRequestSelected;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public List<JobRequest> all() {

		return jobRequestManagementLocal.findAllJobRequestsById(1);

	}

}
