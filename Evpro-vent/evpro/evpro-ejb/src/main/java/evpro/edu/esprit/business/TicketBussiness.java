package evpro.edu.esprit.business;

import java.util.List;




import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import evpro.edu.esprit.interfaces.ITicketbUSSINESSlOCAL;
import evpro.edu.esprit.persistance.Ticket;



@Stateless
public class TicketBussiness implements ITicketbUSSINESSlOCAL{
	
	
	@PersistenceContext (unitName="evpro-ejb")
	EntityManager em;
	
	public TicketBussiness() {
		super();
	}
	public List<Ticket> getAllTicket() {
		return em.createQuery("select e from Ticket e", Ticket.class).getResultList();
	}

}
