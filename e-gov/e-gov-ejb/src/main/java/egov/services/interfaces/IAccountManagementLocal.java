package egov.services.interfaces;
import java.util.List;

import javax.ejb.Local;

import egov.entities.Account;
import egov.entities.User;

@Local
public interface IAccountManagementLocal {
	Boolean addAccount(Account a);

	Boolean updateAccount(Account a);

	void flush();

	Boolean removeAccount(Account c);

	List<Account> findAll();

	Account findAccountByNum(int num);

	Boolean SendMoney(int num1, int num2, float ammount);
	 List<Account> findAllCarByIdUser( User u);
		void affecterAccountUser(Account a , User u);

}
