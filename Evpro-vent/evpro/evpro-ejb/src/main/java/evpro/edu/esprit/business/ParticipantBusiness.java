package evpro.edu.esprit.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import evpro.edu.esprit.interfaces.IParticipantBusinessLocal;
import evpro.edu.esprit.persistance.Event;

import evpro.edu.esprit.persistance.Participant;
import evpro.edu.esprit.persistance.Payment;
import evpro.edu.esprit.persistance.User;


/**
* Session Bean implementation class participantService
*/
@Stateless //ma7achtkch bch bil resultata l9dima ! dima remise a zero ! sans etat c'est le nom de la classe de l'EJB deux clients peuvent acceder a la meme instance
@LocalBean  //using @LocalBean and using no annotation at all are both ways of getting a no-interface view
public class ParticipantBusiness implements IParticipantBusinessLocal {

@PersistenceContext (unitName="evpro-ejb")// injecter un gestionnaire d’entités
private EntityManager em;
	public ParticipantBusiness() {

	}

public void add(Participant participant) {
	em.persist(em.merge(participant));

}

public Participant find(Integer idUser) {

	return  em.find(Participant.class, idUser);
}


public void update(Participant participant) {

	em.merge(participant);
}

public void delete(Participant participant) {
	em.remove(em.merge(participant));
}

@Override
public List<Participant> findAllParticipant() {
	return em
			.createQuery("select p from Participant p", Participant.class)
			.getResultList();

}

public List<Event> findAllParticipantEvents(Integer idUser) {

		return em.createQuery("select e from Event e join e.payments p where p.participantPayment.idUser=:param" ,Event.class)
				.setParameter("param", idUser).getResultList();
	}



}
