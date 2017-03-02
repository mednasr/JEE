package evpro.edu.esprit.interfaces;
import java.util.List;

import javax.ejb.Remote;

import evpro.edu.esprit.persistance.Event;
import evpro.edu.esprit.persistance.Orgnizer;


@Remote
public interface IOrgnizerBusinessRemote {
void ajouterOrgnizer(Orgnizer orgnizer);
	
	void modifierOrgnizer(Orgnizer orgnizer);
	
	void supprimerOrgnizer(Orgnizer orgnizer);
	
	Orgnizer chercherOrgnizer(Integer id);
	
	 List<Orgnizer> findAllOrgnizers();

	List<Event> findAllEventOrgnizer(Integer id);

}
