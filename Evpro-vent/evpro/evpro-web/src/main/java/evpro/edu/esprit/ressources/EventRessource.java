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

import evpro.edu.esprit.interfaces.IEventBusinessLocal;
import evpro.edu.esprit.persistance.Event;
import evpro.edu.esprit.persistance.Orgnizer;
import evpro.edu.esprit.persistance.Participant;

@Path("event")
@RequestScoped
public class EventRessource {

	@EJB
		IEventBusinessLocal eventBusinessLocal;

		
		
		
		@POST
		@Path("/add")
		@Consumes("application/json")
		public void add(Event event) {
			eventBusinessLocal.ajouterEvent(event);
		}

		@GET
		@Path("/find/{id}")
		@Produces("application/json")
		public Event find(@PathParam("id") Integer id) {

			return eventBusinessLocal.chercherEvent(id);

		}
		
		
		@PUT
	    @Path("/update")
		@Consumes("application/json")
	    public void update(Event event)
		{

			System.out.println("777777777");
			System.out.println(event);
			System.out.println("888888888");
			
			eventBusinessLocal.modifierEvent(event);
		}
		
		@PUT
		@Path("/delete")
		@Consumes("application/json")
		public void delete(Event event) {

			eventBusinessLocal.supprimerEvent(event);

		}
		
		@GET
		@Produces("application/json") /// la differenece entre @Produces(MediaType.APPLICATION_JSON)
			public Response findAllEvents()
		{
			
			List<Event> Events =eventBusinessLocal.getAllEvents();
			
			if (Events==null)
				return Response.status(Status.NOT_FOUND).entity("No Events Found").build();
			else
				return Response.ok(Events).build();

		}

	
		@GET
		@Path("/findAllParticipant/{id}")
		@Produces("application/json")
		public List<Participant> getAllEventParticipants(@PathParam("id") Integer id) {
			
			return eventBusinessLocal.findAllEventParticipants(id);
			
		}
		
		@GET
		@Path("/findAllOrgnizer/{id}")
		@Produces("application/json")
		public List<Participant> getAllEvent(@PathParam("id") Integer id) {
			
			return eventBusinessLocal.findAllEventParticipants(id);
			
		}
	
        
		
}
