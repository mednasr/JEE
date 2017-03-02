package evpro.edu.esprit.interfaces;

import java.util.List;

import javax.ejb.Remote;

import evpro.edu.esprit.persistance.Event;
import evpro.edu.esprit.persistance.Participant;




@Remote
public interface IEventBusinessRemote {

	void ajouterEvent(Event event);

	void modifierEvent(Event event);

	void supprimerEvent(Event event);

	
	Event chercherEvent(Integer id);
	
	public Event find(Integer id);

	public List<Event> getAllEvents();


	public List<Participant> findAllEventParticipants(Integer id);
}
