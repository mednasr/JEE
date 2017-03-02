package evpro.edu.esprit.business;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import evpro.edu.esprit.interfaces.IEventBusinessLocal;
import evpro.edu.esprit.interfaces.IEventBusinessRemote;
import evpro.edu.esprit.persistance.Event;
import evpro.edu.esprit.persistance.Orgnizer;
import evpro.edu.esprit.persistance.Participant;

//@EJB //@EJB permet d'injecter une ressource de type EJB.
@Stateless
public class EventBusiness implements IEventBusinessLocal, IEventBusinessRemote {

	@PersistenceContext(unitName = "evpro-ejb")
	EntityManager em;

	public EventBusiness() {
		super();
	}

	@Override
	public void ajouterEvent(Event event) {
		// TODO Auto-generated method stub
		em.persist(event);

	}

	@Override
	public void modifierEvent(Event event) {
		// TODO Auto-generated method stub
		em.merge(event);

	}

	@Override
	public void supprimerEvent(Event event) {
		// TODO Auto-generated method stub
		
		em.remove(em.merge(event));

	}

	public Event chercherEvent(Integer id) {
		// TODO Auto-generated method stub
		return em.find(Event.class, id);

	}

	public List<Event> getAllEvents() {
		return em.createQuery("select e from Event e", Event.class).getResultList();
	}

	public List<Participant> findAllEventParticipants(Integer id) {
		Query query = em
				.createQuery("select p from Participant p join p.payments e where e.eventPayment.idEvent= :param");
		query.setParameter("param", id);
		return query.getResultList();
	}

	public List<Orgnizer> findAllEventOrgnizer(Integer id) {
		Query query = em.createQuery("select o from Orgnizer o join o.Events e where e.idEvent= :param");
		query.setParameter("param", id);
		return query.getResultList();
	}

	public Event find(Integer idEvent) {

		return em.find(Event.class, idEvent);
	}

}
