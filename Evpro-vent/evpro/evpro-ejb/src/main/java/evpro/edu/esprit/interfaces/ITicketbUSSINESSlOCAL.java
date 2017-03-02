package evpro.edu.esprit.interfaces;

import java.util.List;

import javax.ejb.Local;


import evpro.edu.esprit.persistance.Ticket;



@Local
public interface ITicketbUSSINESSlOCAL {
	
	
	public List<Ticket> getAllTicket();
}
