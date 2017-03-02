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

import evpro.edu.esprit.interfaces.IOrgnizerBusinessLocal;
import evpro.edu.esprit.persistance.Event;
import evpro.edu.esprit.persistance.EventOwner;
import evpro.edu.esprit.persistance.Orgnizer;
import evpro.edu.esprit.persistance.Participant;
import evpro.edu.esprit.persistance.User;


@Path("/orgnizer")
@RequestScoped
public class OrgnizerRessource {
	@EJB
	IOrgnizerBusinessLocal orgnizerBusinessLocal;
	
	
	@POST
	@Path("/add")
	@Consumes("application/json")
	public void ajouterOrgnizer(Orgnizer orgnizer){
		orgnizerBusinessLocal.ajouterOrgnizer(orgnizer);
	}
	
	@DELETE
	@Path("/delete")
	@Consumes("application/json")
	public void supprimerOrgnizer(Orgnizer orgnizer) {

		orgnizerBusinessLocal.supprimerOrgnizer(orgnizer);
	}
	
	@PUT
    @Path("/update")
	@Consumes("application/json")
    public void modifierOrgnizer(Orgnizer orgnizer)
	{
		orgnizerBusinessLocal.modifierOrgnizer(orgnizer);
	}

	@GET
	@Path("/find/{id}")
	@Produces("application/json")
	public Orgnizer chercherOrgnizer(@PathParam("id") Integer id) {

		return orgnizerBusinessLocal.chercherOrgnizer(id);
	}
	
	@GET
	@Path("/findAllEvent/{id}")
	@Produces("application/json")
	public List<Event> findAllEventOrgnizer(@PathParam("id") Integer id) {
		
		return orgnizerBusinessLocal.findAllEventOrgnizer(id);
		
	}

	@GET
	@Path("/findAllOrgnizers")
	@Produces("application/json") 
	public Response findAllEvents()
	{
		
		List<Orgnizer> Events =orgnizerBusinessLocal.findAllOrgnizers();
		
		if (Events==null)
			return Response.status(Status.NOT_FOUND).entity("No Events Found").build();
		else
			return Response.ok(Events).build();

	}
	

}
