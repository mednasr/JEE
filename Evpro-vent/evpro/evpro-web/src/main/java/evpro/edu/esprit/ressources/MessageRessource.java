package evpro.edu.esprit.ressources;

import java.util.Date;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import evpro.edu.esprit.interfaces.IMessageBusinessLocal;
import evpro.edu.esprit.persistance.Message;
import evpro.edu.esprit.persistance.Orgnizer;
import evpro.edu.esprit.persistance.Participant;

@Path("/message")
@RequestScoped
public class MessageRessource {
	@EJB
	IMessageBusinessLocal MessageBusinessLocal;

	@POST
	@Consumes("application/json")
	public void add(Message msg) {
		msg.setDate(new Date());
		MessageBusinessLocal.ajouterMessage(msg);
	}

	@GET
	@Path("{id}")
	@Produces("application/json")
	public Response find(@PathParam("id") Integer idMessage) {
		Message m = new Message();
		m = MessageBusinessLocal.chercherMessage(idMessage);
		return Response.status(Status.OK).entity(m).build();

	}

	@GET
	@Path("/finddate/{id}/{iddest}")
	@Produces("application/json")
	public Response findbydate(@PathParam("id") Integer iduser, @PathParam("iddest") Integer iddest) {

		String m = MessageBusinessLocal.findmesgbydate(iduser, iddest);
		return Response.status(Status.OK).entity(m).build();

	}

	@PUT
	@Consumes("application/json")
	public void update(Message msg) {
		MessageBusinessLocal.modifierMessage(msg);
	}

	@PUT
	@Path("/delete")
	@Consumes("application/json")
	public void delete(Message msg) {

		MessageBusinessLocal.supprimerMessage(msg);

	}

	@GET
	@Path("/findmesguser/{orgn}")
	@Produces("application/json")
	public Response findmesgbyuser(@PathParam("orgn") Integer orgn) {

		List<Message> messages = MessageBusinessLocal.findmesgbyuser(orgn);

		if (messages == null)
			return Response.status(Status.NOT_FOUND).entity("No Messages Found").build();
		else
			return Response.status(Status.OK).entity(messages).build();

	}

	@GET
	@Path("/findmesgdest/{orgn}")
	@Produces("application/json")

	public Response findmesgbydest(@PathParam("orgn") Integer orgn) {

		List<Message> messages = MessageBusinessLocal.findmesgbydest(orgn);

		if (messages == null)
			return Response.status(Status.NOT_FOUND).entity("No Messages Found").build();
		else
			return Response.ok(messages).build();

	}

	@GET
	@Path("/finde/{login}")
	@Produces("application/json")
	public Response findmesgbylastname(@PathParam("login") String lastname) {

		List<Message> messages = MessageBusinessLocal.findbylogin(lastname);

		if (messages == null)
			return Response.status(Status.NOT_FOUND).entity("No Messages Found").build();
		else
			return Response.status(Status.OK).entity(messages).build();

	}

	@GET
	@Produces("application/json")
	public Response findAllParticipants() {

		List<Message> Messages = MessageBusinessLocal.findAllMessage();

		if (Messages == null)
			return Response.status(Status.NOT_FOUND).entity("No Participants Found").build();
		else
			return Response.ok(Messages).build();

	}

}
