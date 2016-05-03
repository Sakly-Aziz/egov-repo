package egov.services.interfaces;
import java.util.List;

import javax.ejb.Remote;

import egov.entities.Kase;
@Remote
public interface ICaseManagementRemote {
Boolean addCase(Kase c);
Boolean update(Kase c);
Boolean search(Kase c);
void flush();
Boolean remove(Kase c);
List<Kase> findAll();
Kase findCaseById(int id);
	

}
