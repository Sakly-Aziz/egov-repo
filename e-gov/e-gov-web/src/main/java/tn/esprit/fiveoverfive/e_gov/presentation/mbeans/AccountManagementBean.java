package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.sound.sampled.DataLine.Info;
import com.box.sdk.BoxAPIConnection;
import com.box.sdk.BoxFolder;
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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
@ManagedBean
@ViewScoped
public class AccountManagementBean {
	@EJB
	private IAccountManagementLocal iAccountMangementLocal;
	private IUserMangementLocal iUserMangementLocal;
	private List<Account> accounts = new ArrayList<>();
	private float money;
	private Account account = new Account();
	
	private Account account2 = new Account();
	private Account a = new Account();
	private User u=new User();
	private User user=new User();
	private Account accountSelected = new Account();
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		
		this.accounts = accounts;
	}
	public void doSelectAccount(Account u) {
		accountSelected = u;
	}
	public Account getAccount() {
		
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Account getAccountSelected() {
		return accountSelected;
	}
	public void setAccountSelected(Account accountSelected) {
		this.accountSelected = accountSelected;
	}
	public String doAddAccount() {
		iAccountMangementLocal.addAccount(account);
		return "";
	}
	public String doDeleteAccount(Account accountSelected) {
		iAccountMangementLocal.removeAccount(accountSelected);
		return "/pages/acountManagement/listAccounts?faces-redirect=true";
	}
	public String doUpdateAccount() {
		iAccountMangementLocal.updateAccount(accountSelected);
		return "/pages/acountManagement/listAccounts?faces-redirect=true";
	}
	public String doSendMoney() {
		iAccountMangementLocal.SendMoney(account.getNum(),account2.getNum(), money);
		return "";
	}
	
	public List<Account> doFindAccountByUser(User u){
		accounts=iAccountMangementLocal.findAllCarByIdUser(u);
		return accounts;
	}
	public Account doFindAccountByNum(int num){
		account=iAccountMangementLocal.findAccountByNum(num);
		return account;
	}
	public Account getAccount2() {
		return account2;
	}
	public void setAccount2(Account account2) {
		this.account2 = account2;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	
public User dofindUserById (int id){
	user=iUserMangementLocal.findUserById(id);
	return user;
	
}
public IUserMangementLocal getiUserMangementLocal() {
	return iUserMangementLocal;
}
public void setiUserMangementLocal(IUserMangementLocal iUserMangementLocal) {
	this.iUserMangementLocal = iUserMangementLocal;
}
public Account getA() {
	return a;
}
public void setA(Account a) {
	this.a = a;
}
public User getU() {
	return u;
}
public void setU(User u) {
	this.u = u;
}
	
	
	public void doPdf( Account accountSelected){
		
	Document document = new Document();
	document.newPage();
	try {
		
		
	
	
		PdfWriter.getInstance(document,
				new FileOutputStream("D:/Bank extract"+accountSelected.getNum()+".pdf"));
		document.open();
		Font font = new Font(Font.FontFamily.TIMES_ROMAN, 48, Font.ITALIC | Font.BOLD | Font.BOLD);
		Paragraph p1 = new Paragraph("Account Extract ");
		
		Paragraph p2 = new Paragraph(""+accountSelected.getAmmount());
		Paragraph p3 = new Paragraph("ammount:"+accountSelected.getNum());
		
		p1.setAlignment(Element.ALIGN_CENTER);
		p2.setAlignment(Element.ALIGN_CENTER);
		p3.setAlignment(Element.ALIGN_CENTER);
		
		document.add(p1);
		// add blank line
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
	
	
		
	
		
			
	@PostConstruct
	public void init() {
		accounts = iAccountMangementLocal.findAll();
	
				
	}
	public String doAffecterAcountToUser(){
		iAccountMangementLocal.affecterAccountUser(a, u);
		return "/pages/acountManagement/listAccounts?faces-redirect=true";
		
	}
	
	public void box( Account accountSelected){
		
	Document document = new Document();
	document.newPage();
	try {
		
		
	
	
		PdfWriter.getInstance(document,
				new FileOutputStream("D:/Bank extract"+accountSelected.getNum()+".pdf"));
		document.open();
		Font font = new Font(Font.FontFamily.TIMES_ROMAN, 48, Font.ITALIC | Font.BOLD | Font.BOLD);
		Paragraph p1 = new Paragraph(" Account Extract ");
		
		Paragraph p2 = new Paragraph(""+accountSelected.getAmmount());
		Paragraph p3 = new Paragraph("ammount:"+accountSelected.getNum());
		
		p1.setAlignment(Element.ALIGN_CENTER);
		p2.setAlignment(Element.ALIGN_CENTER);
		p3.setAlignment(Element.ALIGN_CENTER);
		
		document.add(p1);
		// add blank line
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
	
	
    BoxAPIConnection api = new BoxAPIConnection("Dok7nH00LaQ7eTvHCfCridmtTdmjELEL");
	BoxFolder rootFolder = BoxFolder.getRootFolder(api);
	for (com.box.sdk.BoxItem.Info itemInfo : rootFolder) {
	    System.out.format("[%s] %s\n", itemInfo.getID(), itemInfo.getName());
	}
	FileInputStream stream = null;
	try {
		stream = new FileInputStream("D:/Bank extract"+accountSelected.getNum()+".pdf");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	rootFolder.uploadFile(stream,"Bank extract"+accountSelected.getNum()+".pdf");
	try {
		stream.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	
	
    public void buttonAction(ActionEvent actionEvent) {
        addMessage("Welcome in "+account.getName()+" Bank");
    }
     
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
    public void save() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Welcome "));
    }
    
    public void submit() {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correct", "Correct");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
  
	}