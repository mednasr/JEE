package evpro.edu.esprit.interfaces;

import java.util.List;

import javax.ejb.Remote;

import evpro.edu.esprit.persistance.EventOwner;
@Remote
public interface IEventOwnerBusinessRemote {
	
	void ajouterEventOwner(EventOwner eventOwner);
	
	void modifierEventOwner(EventOwner eventOwner);
	
	void supprimerEventOwner (EventOwner eventOwner);
	
	EventOwner chercherEventOwner (Integer id);
	
	List<EventOwner> findAllEventOwners();

}
