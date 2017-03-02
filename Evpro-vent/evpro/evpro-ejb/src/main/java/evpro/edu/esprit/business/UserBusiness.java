package evpro.edu.esprit.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.AuthenticationException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import evpro.edu.esprit.interfaces.IUserBusinessLocal;
import evpro.edu.esprit.interfaces.IUserBusinessRemote;
import evpro.edu.esprit.persistance.Event;
import evpro.edu.esprit.persistance.EventOwner;
import evpro.edu.esprit.persistance.Participant;
import evpro.edu.esprit.persistance.User;


@Stateless
public class UserBusiness implements IUserBusinessLocal,IUserBusinessRemote {
	
	@PersistenceContext(unitName="evpro-ejb")
	EntityManager em;

	public UserBusiness() {
		super();
	}

	@Override
	public void ajouterUser(User user) {
		// TODO Auto-generated method stub
		em.persist(user);
		
	}

	@Override
	public void modifierUser(User user) {
		// TODO Auto-generated method stub
		em.merge(user);
		
	}

	@Override
	public void supprimerUser(User user) {
		// TODO Auto-generated method stub
		em.remove(em.merge(user));
		
	}

	@Override
	public User chercherUser(Integer id) {
		// TODO Auto-generated method stub
		return em.find(User.class, id);
		
	}
	
	@Override
	public User authentificate(String mail, String password) {
		Query query = em.createQuery("select u	 from User u where u.mail=:param1 and u.password=:param2");
		query.setParameter("param1",mail).setParameter("param2", password);
		User user = null;
		try {
			user = (User) query.getSingleResult();
		} catch (Exception e) {
			System.out.println("error " + e.getMessage());
		}
		return user;
	}

	
	
	
	@Override
	public User findByMail(String mail) {
		Query q = em.createQuery("select u from User u where u.mail=:x");
		q.setParameter("x", mail);
		return (User) q.getResultList().get(9);
	}
	
	
	@Override
	public List<User>findAllUsers() {
		return em
				.createQuery("select u from User u", User.class)
				.getResultList();
	}
	

	

	

}
