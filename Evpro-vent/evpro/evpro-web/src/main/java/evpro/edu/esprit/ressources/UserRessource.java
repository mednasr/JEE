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

import evpro.edu.esprit.interfaces.IUserBusinessLocal;
import evpro.edu.esprit.persistance.Event;
import evpro.edu.esprit.persistance.Reward;
import evpro.edu.esprit.persistance.User;
@Path("/User")
@RequestScoped
public class UserRessource {
	@EJB
	IUserBusinessLocal userBusinessLocal;
	
	
	@POST
	@Path("/add")
	@Consumes("application/json")
	public void ajouterUser(User user){
		userBusinessLocal.ajouterUser(user);
	}
	
	@DELETE
	@Path("/delete")
	@Consumes("application/json")
	public void supprimerUser(User user) {

		userBusinessLocal.supprimerUser(user);
	}
	
	@PUT
    @Path("/update")
	@Consumes("application/json")
    public void modiferUser(User user)
	{
		userBusinessLocal.modifierUser(user);
	}

	@GET
	@Path("/find/{id}")
	@Produces("application/json")
	public User chercherUser(@PathParam("id") Integer id) {

		return userBusinessLocal.chercherUser(id);
	}
	@GET
	@Path("/findAllUsers")
	@Produces("application/json") 
	public Response findAllEvents()
	{
		
		List<User> Events =userBusinessLocal.findAllUsers();
		
		if (Events==null)
			return Response.status(Status.NOT_FOUND).entity("No Events Found").build();
		else
			return Response.ok(Events).build();

	}
	
	
	
	
}
