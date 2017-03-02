package evpro.edu.esprit.interfaces;

import java.util.List;

import javax.ejb.Local;

import evpro.edu.esprit.persistance.Event;
import evpro.edu.esprit.persistance.Orgnizer;
import evpro.edu.esprit.persistance.Participant;



@Local
public interface IOrgnizerBusinessLocal {
	
	void ajouterOrgnizer(Orgnizer orgnizer);

	void modifierOrgnizer(Orgnizer orgnizer);

	void supprimerOrgnizer(Orgnizer orgnizer);

	Orgnizer chercherOrgnizer(Integer id);
	
	List<Orgnizer> findAllOrgnizers();
	
	public List<Event> findAllEventOrgnizer(Integer id);
	
	
	

}