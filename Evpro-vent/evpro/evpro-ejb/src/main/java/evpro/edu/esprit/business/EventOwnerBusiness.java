package evpro.edu.esprit.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import evpro.edu.esprit.interfaces.IEventOwnerBusinessLocal;
import evpro.edu.esprit.interfaces.IEventOwnerBusinessRemote;
import evpro.edu.esprit.persistance.EventOwner;
import evpro.edu.esprit.persistance.Participant;
import evpro.edu.esprit.persistance.User;

@Stateless //ma7achtkch bch bil resultata l9dima ! dima remise a zero ! sans etat c'est le nom de la classe de l'EJB deux clients peuvent acceder a la meme instance
@LocalBean
public class EventOwnerBusiness implements IEventOwnerBusinessLocal ,IEventOwnerBusinessRemote {
	
	@PersistenceContext(unitName="evpro-ejb")
	EntityManager em;

	public EventOwnerBusiness() {
		super();
	}

	@Override
	public void ajouterEventOwner(EventOwner eventOwner) {
		// TODO Auto-generated method stub
		em.persist(eventOwner);
		
	}

	@Override
	public void modifierEventOwner(EventOwner eventOwner) {
		// TODO Auto-generated method stub
		em.merge(eventOwner);
		
		
	}
	
	

	@Override
	public void supprimerEventOwner(EventOwner eventOwner) {
		// TODO Auto-generated method stub
		em.remove(em.merge(eventOwner));
		
	}
	
	

	@Override
	public EventOwner chercherEventOwner(Integer id) {
		// TODO Auto-generated method stub
		return em.find(EventOwner.class, id);
	}
	
	@Override
	public List<EventOwner>findAllEventOwners() {
		return em
				.createQuery("select e from EventOwner e", EventOwner.class)
				.getResultList();
	}

}

