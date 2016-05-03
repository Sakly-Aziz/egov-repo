package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.naming.Context;
import javax.naming.InitialContext;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte; 
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper; 

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

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


	public void doPdfModifié( User userSelected){
		
		 Image image1 = null ;
	     Image image2= null ;
	     Image image3= null ;
	     Image image4= null ;
	    int SizeImages=0;
	     List<Image> tabImage = new ArrayList<Image>();
	     List<String> NameArticle = new ArrayList<String>();
	     List<Float> Price = new ArrayList<Float>();
	   //  Image tabImage[] = null;
		try { 
			
          
         /*     List<User> liste = proxy.list();
              int size = 0;
             
              for (News n : liste) {
            	  
            	   byte[] b =n.getPicture();
                   ByteArrayInputStream in = new ByteArrayInputStream(b);
                   BufferedImage read = ImageIO.read(in);
                   image1= Image.getInstance(read, null);
                   
                   tabImage.add(image1);
                   NameArticle.add(n.getTitle());
                   Price.add((float) n.getId());
                    SizeImages = tabImage.size();
                   System.out.println("*****************"+SizeImages);
                   size ++ ;
                  
                  }
                 */

            	 
              
			PdfReader pdfReader = new PdfReader("D:\\TestFile1.pdf"); 
			//- See more at: http://tutorialspointexamples.com/itext-edit-add-modify-write-an-existing-pdf-file-in-java/#sthash.nuD8Fq4a.dpuf
			//Create PdfStamper instance.
			PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("D:\\ModifiedTestFilesssh.pdf")); 
		
			//Create BaseFont instance.
			BaseFont baseFont = BaseFont.createFont( BaseFont.TIMES_ROMAN, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			PdfContentByte pageContentByte = pdfStamper.getOverContent(2);
			pageContentByte.beginText();
			pageContentByte.setFontAndSize(baseFont, 14);
			
		
			

  			int PageNumber = 2 ;
			int PhotoInPage= 4 ;
			boolean Addpage=false;
			int boucle = 0;
			for (Image Img : tabImage) {
				if ( Addpage==true ){
						PageNumber++;
						//pdfStamper.ad
						pdfStamper.insertPage(pdfReader.getNumberOfPages() + 1, pdfReader.getPageSizeWithRotation(1));
						pageContentByte = pdfStamper.getOverContent(PageNumber);
						PhotoInPage=1;
						
						
				
				
					
				}
				
				if (PhotoInPage==1 ){
					BaseFont baseFont1 = BaseFont.createFont( baseFont.TIMES_ROMAN, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
				//Img.setWidthPercentage(600);
				//Img.scalePercent(50);
				//Img.scaleAbsolute(400, 400);
					Img.scaleAbsolute(1100,1300);
				Img.setAbsolutePosition(-6f, 0f); 
				Img.setWidthPercentage(80);
				Img.scalePercent(50);
				pageContentByte.setFontAndSize(baseFont1,14);
				pageContentByte.setTextMatrix(300f, 500f);
				
				pageContentByte.showText(NameArticle.get(boucle));
			    pageContentByte.addImage(Img);}
				if (PhotoInPage==2 ){
					BaseFont baseFont1 = BaseFont.createFont( BaseFont.TIMES_ROMAN, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
					pageContentByte.setFontAndSize(baseFont1, 14);
					Img.setWidthPercentage(80);
					Img.scalePercent(50);
					Img.setAbsolutePosition(-10f,400f);
					
				    pageContentByte.addImage(Img);
				    pageContentByte.setTextMatrix(300f,400f);
					
					pageContentByte.showText(NameArticle.get(boucle));
					
				}
				if (PhotoInPage==3 ){
					BaseFont baseFont1 = BaseFont.createFont( BaseFont.TIMES_ROMAN, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
					pageContentByte.setFontAndSize(baseFont1, 14);
					Img.setWidthPercentage(80);
					Img.scalePercent(50);
					Img.setAbsolutePosition(-6f,0f);
					
				    pageContentByte.addImage(Img);
				    pageContentByte.setTextMatrix(300f,0f);
					
					pageContentByte.showText(NameArticle.get(boucle)); 
					
				}
				if (PhotoInPage==4){
					
					Img.setWidthPercentage(80);
					Img.scalePercent(50);
					Img.setAbsolutePosition(-6f,0f); 
				    pageContentByte.addImage(Img);
				    pageContentByte.addImage(Img);
				    pageContentByte.setTextMatrix(300f,0f);
					
				    Addpage=true;
				   
				}
				PhotoInPage++;
			boucle++;
				
				
				
			}
			pageContentByte.endText();
			pdfStamper.close();
			
			
		}
		catch (Exception e) { e.printStackTrace(); }
	}

}
