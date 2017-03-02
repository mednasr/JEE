package evpro.edu.esprit.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import evpro.edu.esprit.interfaces.IOrgnizerBusinessLocal;
import evpro.edu.esprit.interfaces.IOrgnizerBusinessRemote;
import evpro.edu.esprit.persistance.Event;
import evpro.edu.esprit.persistance.EventOwner;
import evpro.edu.esprit.persistance.Orgnizer;
import evpro.edu.esprit.persistance.User;


@Stateless
public class OrgnizerBusiness implements IOrgnizerBusinessLocal,IOrgnizerBusinessRemote {
	
	@PersistenceContext(unitName="evpro-ejb")
	EntityManager em;

	public OrgnizerBusiness() {
		super();
	}

	@Override
	public void ajouterOrgnizer(Orgnizer orgnizer) {
		// TODO Auto-generated method stub
		em.persist(orgnizer);
		
	}

	@Override
	public void modifierOrgnizer(Orgnizer orgnizer) {
		// TODO Auto-generated method stub
		em.merge(orgnizer);
		
	}

	@Override
	public void supprimerOrgnizer(Orgnizer orgnizer) {
		// TODO Auto-generated method stub
		em.remove(em.merge(orgnizer));
		
	}

	@Override
	public Orgnizer chercherOrgnizer(Integer id) {
		// TODO Auto-generated method stub
		return em.find(Orgnizer.class, id);
	}
	
	@Override
	public List<Orgnizer>findAllOrgnizers() {
		return em
				.createQuery("select o from Orgnizer o", Orgnizer.class)
				.getResultList();
	}

	@Override
	public List<Event> findAllEventOrgnizer(Integer id) {
		return em.createQuery("select e from Event e join e.orgnizerEvents p where p.idUser=:param" ,Event.class)
				.setParameter("param", id).getResultList();
	}
	

	

}
