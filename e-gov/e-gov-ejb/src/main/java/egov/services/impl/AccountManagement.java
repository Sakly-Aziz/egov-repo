package egov.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import egov.entities.Account;
import egov.entities.Car;
import egov.entities.User;
import egov.services.interfaces.IAccountManagementLocal;
import egov.services.interfaces.IAccountManagementRemote;

@Stateless
public class AccountManagement implements IAccountManagementRemote, IAccountManagementLocal {
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
		em.remove(em.merge(a));
		return true;

	}

	@Override
	public List<Account> findAll() {
		List<Account> accounts = new ArrayList<>();
		Query query = em.createQuery("select a from Account a ");
		return query.getResultList();
	}

	@Override
	public Account findAccountByNum(int num) {
		Account account = null;
		try {
			account = em.find(Account.class, num);

		} catch (Exception e) {

		}
		return account;
	}

	@Override
	public Boolean SendMoney(int num1, int num2, float ammount) {
		boolean x = true;

		Account account1 = em.find(Account.class, num1);
		Account account2 = em.find(Account.class, num2);

		if (ammount > account1.getAmmount()) {
			x = false;

		} else {
			account1.setAmmount(account1.getAmmount() - ammount);
			account2.setAmmount(account2.getAmmount() + ammount);
		}
		return x;

	}
	

	public List<Account> findAllCarByIdUser( User u)
	{
		
		TypedQuery<Account> query =  em.createNamedQuery("findAccountByUser", Account.class);
		query.setParameter("var", u.getIdUser());
		List<Account> accounts= query.getResultList();
		return accounts;
		
		
		
	}

}
