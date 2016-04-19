package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import egov.entities.Kase;
import egov.services.interfaces.ICaseManagementLocal;

@ManagedBean
@ViewScoped

public class CaseBean {
	@EJB
	private ICaseManagementLocal iCaseManagementLocal;
	private boolean renderForm = false;

	private List<Kase> cases = new ArrayList<>();
	private Kase kase = new Kase();
	private Kase caseSelected;

	@PostConstruct
	public void init() {
		cases = iCaseManagementLocal.findAll();
		if (FacesContext.getCurrentInstance().getExternalContext().getFlash().get("caseselected") == null) {
			System.out.println("is null!!!!!!!!!!!!!!!");
			caseSelected = new Kase();
		} else {
			System.out.println("found!!!!!!!!!!!!");
			caseSelected = (Kase) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("caseselected");
		}
	}

	public String doAddCase() {
		System.out.println("i'm in add method");
		System.out.println("caseselected = " + caseSelected);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("caseselected", this.caseSelected);

		iCaseManagementLocal.addCase(caseSelected);
		return "/pages/caseManagement/listCase?faces-redirect=true";
	}

	public String doDeleteCase(Kase caseSelected) {
		iCaseManagementLocal.remove(caseSelected);
		return "/pages/caseManagement/listCase?faces-redirect=true";
	}

	public String doUpdateCase() {
		iCaseManagementLocal.update(caseSelected);
		return "/pages/caseManagement/listCases?faces-redirect=true";
	}

	public List<Kase> getCases() {
		return cases;
	}

	public void setCases(List<Kase> cases) {
		this.cases = cases;
	}

	public Kase getCaseSelected() {
		return caseSelected;
	}

	public void setCaseSelected(Kase caseSelected) {
		this.caseSelected = caseSelected;
	}

	public Kase getKase() {
		return kase;
	}

	public void setKase(Kase kase) {
		this.kase = kase;
	}

	public boolean isRenderForm() {
		return renderForm;
	}

	public void setRenderForm(boolean renderForm) {
		this.renderForm = renderForm;
	}

	public void doPdf(Kase ac) {

		Document document = new Document();
		document.newPage();
		try {

			PdfWriter.getInstance(document,

					new FileOutputStream("G:\\a.pdf"));

			document.open();

			Font font = new Font(Font.FontFamily.TIMES_ROMAN, 48, Font.ITALIC | Font.BOLD | Font.BOLD);

			Paragraph p1 = new Paragraph("Bulletin 3 ");
			Paragraph p2 = new Paragraph("num" + ac.getNameCase());
			Paragraph p3 = new Paragraph("jud:" + ac.getJudgment());

			p1.setAlignment(Element.ALIGN_CENTER);
			p2.setAlignment(Element.ALIGN_CENTER);
			p3.setAlignment(Element.ALIGN_CENTER);

			document.add(p1);
			document.add(Chunk.NEWLINE);
			document.add(p2);
			document.add(Chunk.NEWLINE);
			document.add(p3);

			document.add(Chunk.NEWLINE);

			document.close();
		} catch (Exception n) {
			System.out.println(n);
		}
		document.close();
	}

}
