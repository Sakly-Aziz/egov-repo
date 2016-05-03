package egov.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import egov.entities.Kase;

@Local
public interface ICaseManagementLocal {
	
		Boolean addCase(Kase c);

		Boolean update(Kase c);
		Boolean search(Kase c);
		
		void flush();
		
		Boolean remove(Kase c);

		List<Kase> findAll();

		Kase findCaseById(int id);
	}


