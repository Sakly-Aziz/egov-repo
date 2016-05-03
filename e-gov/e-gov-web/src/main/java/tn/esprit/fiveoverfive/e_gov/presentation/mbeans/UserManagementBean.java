package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import egov.entities.Account;
import egov.entities.User;
import egov.services.interfaces.IAccountManagementLocal;
import egov.services.interfaces.IUserMangementLocal;

@ManagedBean
@SessionScoped
public class UserManagementBean {
	@EJB
	private IUserMangementLocal iUserMangementLocal;
	private IAccountManagementLocal iAccountMangementLocal;
	private Account a = new Account();
	private User u=new User();

	private List<User> users = new ArrayList<>();
	private User user = new User();
	private User userSelected = new User();
	
	private String gender;
    

	public void setUser(User user) {
		this.user = user;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public User getUser() {
		return user;
	}

	public void setAccount(User user) {
		this.user = user;
	}

	public User getUserSelected() {
		return userSelected;
	}

	public void setUserSelected(User userSelected) {
		this.userSelected = userSelected;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String doAddUser() {
		iUserMangementLocal.addUser(user);
		return "";
	}

	public String doDeleteUser(User userSelected) {
		iUserMangementLocal.remove(userSelected);
		return "/pages/userManagement/listUser?faces-redirect=true";
	}

	public String doUpdateUser() {
		iUserMangementLocal.update(userSelected);
		return "";
	}

	public void doSelectUser(User u) {
		userSelected = u;
	}

	public List<User> getUsers1() {
		users = iUserMangementLocal.findAll();
		return users;
	}

	public void setCars(List<User> users) {
		this.users = users;
	}
	
	public String doAffecterAcountToUser(){
		iAccountMangementLocal.affecterAccountUser(a, userSelected);
		return "/pages/acountManagement/listAccounts?faces-redirect=true";
		
	}
	
	@PostConstruct
	public void init() {
		u.setIdUser(200);
	u.setFirstName("amine");
	u.setLastName("bouderbala");
	
				

	}
	
	public void doPdfBirth( User userSelected){
		
	Document document = new Document();
	document.newPage();
	try {
		
	PdfWriter.getInstance(document, new FileOutputStream("D:\\lol"+userSelected.getFirstName()+".pdf"));

		document.open();
		Font font = new Font(Font.FontFamily.TIMES_ROMAN, 70, Font.ITALIC | Font.BOLD | Font.BOLD);

		Paragraph p1 = new Paragraph("  Birth Certificate ");

		Font font2 = new Font(Font.FontFamily.TIMES_ROMAN, 48, Font.ITALIC | Font.BOLD | Font.BOLD);

		
		Paragraph p2 = new Paragraph("First Name : "+userSelected.getFirstName());
		Paragraph p3 = new Paragraph("Last Name : "+userSelected.getLastName());
		Paragraph p4 = new Paragraph("Birth Date : "+userSelected.getBirthDate());
		Paragraph p5 = new Paragraph("Birth Place :"+userSelected.getBirthPlace());
		Paragraph p6 = new Paragraph("Nationality : "+userSelected.getNationality());
		Paragraph p7 = new Paragraph("Gender :"+userSelected.getGender());
		Paragraph p8 = new Paragraph("Father's Name :"+userSelected.getFatherName());
		Paragraph p9 = new Paragraph("Mother's Name :"+userSelected.getMotherName());
		
		
		
		

		p1.setAlignment(Element.ALIGN_CENTER);
		p2.setAlignment(Element.ALIGN_CENTER);
		p3.setAlignment(Element.ALIGN_CENTER);
		p4.setAlignment(Element.ALIGN_CENTER);
		p5.setAlignment(Element.ALIGN_CENTER);
		p6.setAlignment(Element.ALIGN_CENTER);
		p7.setAlignment(Element.ALIGN_CENTER);
		p8.setAlignment(Element.ALIGN_CENTER);
		p9.setAlignment(Element.ALIGN_CENTER);
		
		document.add(p1);

		document.add(Chunk.NEWLINE);
		document.add(p2);
		document.add(Chunk.NEWLINE);
		document.add(p3);
		
		document.add(Chunk.NEWLINE);
		
		document.add(p4);

		document.add(Chunk.NEWLINE);
		document.add(p5);

		document.add(Chunk.NEWLINE);
		document.add(p6);

		document.add(Chunk.NEWLINE);
		document.add(p7);

		document.add(Chunk.NEWLINE);
		document.add(p8);

		document.add(Chunk.NEWLINE);
		document.add(p9);

		document.add(Chunk.NEWLINE);
		

		document.close();
	} catch (Exception n) {
		System.out.println(n);
	}
	document.close();
	

}

	public void doPdfDeath( User userSelected){
		
	Document document = new Document();
	document.newPage();
	try {
	
		PdfWriter.getInstance(document,

				new FileOutputStream("D:\\lol"+userSelected.getFirstName()+".pdf"));

		document.open();
		Font font = new Font(Font.FontFamily.TIMES_ROMAN, 70, Font.ITALIC | Font.BOLD | Font.BOLD);

		Paragraph p1 = new Paragraph("  Birth Certificate ");

		Font font2 = new Font(Font.FontFamily.TIMES_ROMAN, 48, Font.ITALIC | Font.BOLD | Font.BOLD);

		
		Paragraph p2 = new Paragraph("First Name : "+userSelected.getFirstName());
		Paragraph p3 = new Paragraph("Last Name : "+userSelected.getLastName());
		Paragraph p4 = new Paragraph("Birth Date : "+userSelected.getBirthDate());
		Paragraph p5 = new Paragraph("Birth Place :"+userSelected.getBirthPlace());
		Paragraph p6 = new Paragraph("Birth Place :"+userSelected.getDeathDate());
		Paragraph p7 = new Paragraph("Nationality : "+userSelected.getNationality());
		Paragraph p8 = new Paragraph("Gender :"+userSelected.getGender());
		Paragraph p9 = new Paragraph("Father's Name :"+userSelected.getFatherName());
		Paragraph p10 = new Paragraph("Mother's Name :"+userSelected.getMotherName());
		
		
		
		

		p1.setAlignment(Element.ALIGN_CENTER);
		p2.setAlignment(Element.ALIGN_CENTER);
		p3.setAlignment(Element.ALIGN_CENTER);
		p4.setAlignment(Element.ALIGN_CENTER);
		p5.setAlignment(Element.ALIGN_CENTER);
		p6.setAlignment(Element.ALIGN_CENTER);
		p7.setAlignment(Element.ALIGN_CENTER);
		p8.setAlignment(Element.ALIGN_CENTER);
		p9.setAlignment(Element.ALIGN_CENTER);
		p10.setAlignment(Element.ALIGN_CENTER);
		
		document.add(p1);

		document.add(Chunk.NEWLINE);
		document.add(p2);
		document.add(Chunk.NEWLINE);
		document.add(p3);
		
		document.add(Chunk.NEWLINE);
		
		document.add(p4);

		document.add(Chunk.NEWLINE);
		document.add(p5);

		document.add(Chunk.NEWLINE);
		document.add(p6);

		document.add(Chunk.NEWLINE);
		document.add(p7);

		document.add(Chunk.NEWLINE);
		document.add(p8);

		document.add(Chunk.NEWLINE);
		document.add(p9);

		document.add(Chunk.NEWLINE);
		document.add(p10);

		document.add(Chunk.NEWLINE);
		
		

		document.close();
	} catch (Exception n) {
		System.out.println(n);
	}
	document.close();
	

}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


}
