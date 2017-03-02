package evpro.edu.esprit.interfaces;

import java.util.List;

import javax.ejb.Local;

import evpro.edu.esprit.persistance.EventOwner;
import evpro.edu.esprit.persistance.User;

@Local
public interface IEventOwnerBusinessLocal {

	
	void ajouterEventOwner(EventOwner eventOwner);
	
	void modifierEventOwner(EventOwner eventOwner);
	
	void supprimerEventOwner (EventOwner eventOwner);
	
	public EventOwner chercherEventOwner (Integer id);
	
	List<EventOwner> findAllEventOwners();
	
}
