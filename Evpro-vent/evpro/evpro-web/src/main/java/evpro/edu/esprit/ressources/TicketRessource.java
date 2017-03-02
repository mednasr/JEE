package evpro.edu.esprit.ressources;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import evpro.edu.esprit.interfaces.ITicketbUSSINESSlOCAL;
import evpro.edu.esprit.persistance.Ticket;


@Path("ticket")
@RequestScoped
public class TicketRessource {


	    @EJB
		ITicketbUSSINESSlOCAL eventBusinessLocal;

		
		
		@GET
		@Produces("application/json") 
			public Response findAllEvents()
		{
			
			List<Ticket> Tickets =eventBusinessLocal.getAllTicket();
			
			if (Tickets==null)
				return Response.status(Status.NOT_FOUND).entity("No Tickets Found").build();
			else
				return Response.ok(Tickets).build();

		}

	
	
        
		
}
