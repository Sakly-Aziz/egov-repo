package egov.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import egov.entities.Account;
import egov.entities.Car;
import egov.entities.Kase;
import egov.entities.User;
import egov.services.interfaces.IUserManagementRemote;
import egov.services.interfaces.IUserMangementLocal;

@Stateless
public class UserManagement implements IUserManagementRemote, IUserMangementLocal {
	@PersistenceContext
	EntityManager Us;

	public Boolean addUser(User u) {

		try {
			Us.persist(u);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void flush() {
		Us.flush();
	}

	public Boolean update(User u) {

		try {
			Us.merge(u);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public Boolean remove(User u) {
		try {
			Us.remove(Us.merge(u));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public User findUserById(int id) {
		User user = null;
		try {
			user = Us.find(User.class, id);

		} catch (Exception e) {

		}
		return user;
	}

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		Query query = Us.createQuery("select u from User u");
		return query.getResultList();
	}

	@Override

	public User authentificate(String login, String pwd) {
		User user = null;
		Query query = Us.createQuery("Select u from User u where u.login=:login and u.pwd=:pwd");
		query.setParameter("login", login).setParameter("pwd", pwd);
		try {
			user = (User) query.getSingleResult();

		} catch (Exception e) {
			user = null;
		}
		return user;
	}

	public List<Car> findCarByIdUser(int id) {
		User user = null;
		user = Us.find(User.class, id);
		List<Car> cars = new ArrayList<>();
		Query query = Us.createQuery("select c from car c where c.idUser=:id");
		return query.getResultList();

	}

	@Override
	public String findpwd(String email) {
		Query query = Us.createQuery("SELECT pwd FROM User u where email =:email");
		query.setParameter("email", email);
		return (String) query.getSingleResult();
	}

	@Override
	public Boolean removeUserById(int id) {
		User user = new User();
		try {
			user = Us.find(User.class, id);
			Us.remove(Us.merge(user));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Kase> CaseByUser(User m) {

		String rq = "select a from Kase a where a.user.id= :id";

		Query query = Us.createQuery(rq).setParameter("id", m.getIdUser());
		return query.getResultList();

	}
	public void affecterAccountUser(Account a , User u)
	{
		a=Us.find(Account.class, a.getNum());
		u=Us.find(User.class, u.getIdUser());
		List<Account> accounts=new ArrayList<>();
		accounts=u.getAccounts();
		
		
		a.setUser(u);
		Us.merge(a);
		accounts.add(a);
		u.setAccounts(accounts);
		Us.merge(u);
		
	}

}
