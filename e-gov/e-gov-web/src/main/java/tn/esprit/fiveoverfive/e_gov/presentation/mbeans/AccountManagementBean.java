package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
public class AccountManagementBean {
	@EJB
	private IAccountManagementLocal iAccountMangementLocal;
	private IUserMangementLocal iUserMangementLocal;

	private List<Account> accounts = new ArrayList<>();
	private float money;
	private Account account = new Account();
	private Account account2 = new Account();
	
	private User user=new User();
	private Account accountSelected = new Account();

	public List<Account> getAccounts() {
		accounts = iAccountMangementLocal.findAll();
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
		return "/pages/acountManagement/listAccounts?faces-redirect=true";
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
		return "/pages/acountManagement/listAccounts?faces-redirect=true";
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

	
	/*
	
	public void doPdf(Account account){
		
	Document document = new Document();
	document.newPage();
	try {

		
		
	

	
		PdfWriter.getInstance(document,

				new FileOutputStream("D:\\Death-Certifcate.pdf"));

		document.open();

		Font font = new Font(Font.FontFamily.TIMES_ROMAN, 48, Font.ITALIC | Font.BOLD | Font.BOLD);

		Paragraph p1 = new Paragraph("Death Certificate ");
		Paragraph p2 = new Paragraph("num"+account.getAmmount());
		Paragraph p3 = new Paragraph("ammount:"+account.getNum());
		

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
	*/
	
}
