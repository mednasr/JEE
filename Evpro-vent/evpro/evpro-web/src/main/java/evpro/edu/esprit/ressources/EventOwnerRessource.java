package evpro.edu.esprit.ressources;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import evpro.edu.esprit.interfaces.IEventOwnerBusinessLocal;
import evpro.edu.esprit.persistance.EventOwner;
import evpro.edu.esprit.persistance.Participant;
import evpro.edu.esprit.persistance.User;



@Path("EventOwner")
@RequestScoped
public class EventOwnerRessource {
	
	@EJB
	IEventOwnerBusinessLocal eventOwnerBusinessLocal;
	
	
	
	@POST
	@Path("/add")
	@Consumes("application/json")
	public void ajouterEventOwner(EventOwner eventOwner){
		eventOwnerBusinessLocal.ajouterEventOwner(eventOwner);
	}
	@DELETE
	@Path("/delete")
	@Consumes("application/json")
	public void supprimerEventOwner(EventOwner eventOwner) {

		eventOwnerBusinessLocal.supprimerEventOwner(eventOwner);
	}
	
	@PUT
    @Path("/update")
	@Consumes("application/json")
    public void modifierEventOwner(EventOwner eventOwner)
	{
		eventOwnerBusinessLocal.modifierEventOwner(eventOwner);
	}


	@GET
	@Path("/find/{id}")
	@Produces("application/json")
	public Response find(@PathParam("id") Integer id) {
		EventOwner e = new EventOwner();
		e = eventOwnerBusinessLocal.chercherEventOwner(id);
		return Response.status(Status.OK).entity(e).build();
		
	}
		
		@GET
		@Path("/findAllEventOwners")
		@Produces("application/json") 
		public Response findAllParticipants()
		{
			
			List<EventOwner> Participants =eventOwnerBusinessLocal.findAllEventOwners();
			
			if (Participants==null)
				return Response.status(Status.NOT_FOUND).entity("No Participants Found").build();
			else
				return Response.ok(Participants).build();

		}

	}
	
	
	
	
	

