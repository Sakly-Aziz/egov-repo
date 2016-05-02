package egov.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import egov.entities.Hopital;

@Local
public interface IHopitalManagement {
	public Boolean addHopital(Hopital a);
	public Boolean updateHopital(Hopital a);
	public void flush();
	public Boolean removeHopital(Hopital a);
	public List<Hopital> findAll();
	

}
