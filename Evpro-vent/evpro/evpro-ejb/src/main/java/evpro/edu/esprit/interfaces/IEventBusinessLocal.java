package evpro.edu.esprit.interfaces;

import java.util.List;

import javax.ejb.Local;

import evpro.edu.esprit.persistance.Event;
import evpro.edu.esprit.persistance.Orgnizer;
import evpro.edu.esprit.persistance.Participant;

@Local
public interface IEventBusinessLocal {
	

	
	void ajouterEvent(Event event);

	void modifierEvent(Event event);

	void supprimerEvent(Event event);

	
	Event chercherEvent(Integer id);
	
	public Event find(Integer id);

	public List<Event> getAllEvents();


	public List<Participant> findAllEventParticipants(Integer id);
}
