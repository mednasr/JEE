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

import evpro.edu.esprit.interfaces.IParticipantBusinessLocal;
import evpro.edu.esprit.persistance.Event;
import evpro.edu.esprit.persistance.Participant;

@Path("participant")
@RequestScoped
public class ParticipantRessource {

		@EJB
		IParticipantBusinessLocal participantBusinessLocal;

		
		
		
		@POST
		@Path("/add")
		@Consumes("application/json")
		public void add(Participant participant) {
			participantBusinessLocal.add(participant);
		}

		
		
		
		@GET
		@Path("/find/{id}")
		@Produces("application/json")
		public Response find(@PathParam("id") Integer idUser) {
			Participant p = new  Participant();
			p =  participantBusinessLocal.find(idUser);
			return Response.status(Status.OK).entity(p).build();
			

		}
		
		@PUT
	    @Path("/update")
		@Consumes("application/json")
	    public void update(Participant participant)
		{
			participantBusinessLocal.update(participant);
		}
		
		@DELETE
		@Path("/delete")
		@Consumes("application/json")
		public void delete(Participant participant) {

			participantBusinessLocal.delete(participant);

		}
		
		@GET
		@Produces("application/json") /// la differenece entre @Produces(MediaType.APPLICATION_JSON)
			public Response findAllParticipants()
		{
			
			List<Participant> Participants =participantBusinessLocal.findAllParticipant();
			
			if (Participants==null)
				return Response.status(Status.NOT_FOUND).entity("No Participants Found").build();
			else
				return Response.ok(Participants).build();

		}
		
		

		@GET
		@Path("/findEventByUser/{id}")
		@Produces("application/json")
		public List<Event> getAllParticipantEvents(@PathParam("id") Integer idUser) {
			//System.out.println(idUser);
			return participantBusinessLocal.findAllParticipantEvents(idUser);
			
		}
	
        
		
}
