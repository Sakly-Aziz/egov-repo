package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;


import java.io.FileOutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import egov.entities.Account;

@ManagedBean
public class FileUploadView {
    
   private UploadedFile file;

   public UploadedFile getFile() {
       return file;
   }

   public void setFile(UploadedFile file) {
       this.file = file;
   }
    
   public void upload() {
       if(file != null) {
           FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, message);
       }
   }
   
	
	public void doPdf( UploadedFile file ){
		
	Document document = new Document();
	document.newPage();
	try {

		
		
	

	
		PdfWriter.getInstance(document,

				new FileOutputStream(file+".pdf"));

		document.open();

		Font font = new Font(Font.FontFamily.TIMES_ROMAN, 48, Font.ITALIC | Font.BOLD | Font.BOLD);

		Paragraph p1 = new Paragraph("Account Extract ");
		
		
		

		p1.setAlignment(Element.ALIGN_CENTER);
		
		
		
		document.add(p1);

		// add blank line
		document.add(Chunk.NEWLINE);
		
		

		document.close();
	} catch (Exception n) {
		System.out.println(n);
	}
	document.close();
	

}
}