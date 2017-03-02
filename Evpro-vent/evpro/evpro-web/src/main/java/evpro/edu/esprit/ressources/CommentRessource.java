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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import evpro.edu.esprit.interfaces.ICommentBusinessLocal;
import evpro.edu.esprit.interfaces.IParticipantBusinessLocal;
import evpro.edu.esprit.persistance.Comment;
import evpro.edu.esprit.persistance.CommentPK;
import evpro.edu.esprit.persistance.Participant;

@Path("comment")
@RequestScoped
public class CommentRessource {
	
	@EJB
	ICommentBusinessLocal commentBusinessLocal;

	@POST
	@Path("/add")
	@Consumes("application/json")
	public void add(Comment comment) {
		commentBusinessLocal.add(comment);
	}

	/*@GET
	@Path("/find/{id}")
	@Produces("application/json")
	public Response find(String title) {
		Comment c = new  Comment();
		c =  commentBusinessLocal.findCommentByName(title);
		return Response.status(Status.OK).entity(c).build();
		

	}*/
	@PUT
	@Path("/update")
	@Consumes("application/json")
	public void update(Comment comment) {
		commentBusinessLocal.update(comment);
	}

	@DELETE
	@Path("/delete")
	@Consumes("application/json")
	public void delete(Comment comment) {

		commentBusinessLocal.delete(comment);

	}

	@GET
	@Path("/findAllParticipant/{id}")
	@Produces("application/json")
	public List<Comment> getAllParticipantComment(@PathParam("id") Integer id) {

		return commentBusinessLocal.findAllParticipantComment(id);

	}


}
