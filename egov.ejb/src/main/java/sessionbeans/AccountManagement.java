package sessionbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import egov.entities.Account;
import egov.entities.Car;
import egov.entities.User;

@Stateless
public class AccountManagement implements IAccountManagementRemote{
	@PersistenceContext
	EntityManager em;
	@Override
	public Boolean addAccount(Account a) {
		try {
			em.persist(a);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean updateAccount(Account a) {
		try {
			em.merge(a);
			return true;
		} catch (Exception e) {
			return false;
		}
	
	}

	@Override
	public void flush() {
		em.flush();
		
	}

	@Override
	public Boolean removeAccount(Account a) {
		try {
			em.remove(a);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}



	@Override
	public List<Account> findAll() {
		List<Account>  accounts = new ArrayList<>();
		Query query = em.createQuery("select a from Account a");
		return query.getResultList();
	}
	

	@Override
	public Account findAccountByNum(int num) {
		Account account = null;
		try {
			account = em.find(Account.class,num);

		} catch (Exception e) {

		}
		return account;
	}

	@Override
	public Boolean SendMoney(int num1, int num2, float ammount) {
		boolean x = true;
	
		Account account1 = em.find(Account.class, num1);
		Account account2 = em.find(Account.class, num2);
		
		if (ammount>account1.getAmmount())
		{x=false;
		
		}
		else{
		account1.setAmmount(account1.getAmmount()-ammount);
		account2.setAmmount(account2.getAmmount()+ammount);
		}
		return x;

		
		
		
	}

	
	public void affecterAccountUser(Account a , User u)
	{
		a=em.find(Account.class, a.getNum());
		u=em.find(User.class, u.getIdUser());
		List<Account> accounts=new ArrayList<>();
		accounts=u.getAccounts();
		
		
		a.setUser(u);
		em.merge(a);
		accounts.add(a);
		u.setAccounts(accounts);
		em.merge(u);
		
	}
	

}
