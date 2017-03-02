package evpro.edu.esprit.ressources;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Remove;
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

import evpro.edu.esprit.interfaces.ITaskBusinessLocal;
import evpro.edu.esprit.persistance.Task;
import evpro.edu.esprit.persistance.TaskPK;
import evpro.edu.esprit.persistance.Task;


@Path("/Task")
@RequestScoped
public class TaskRessource {
	@EJB
	 ITaskBusinessLocal taskBusinessLocal;
	
	@POST
	@Path("/addTask")
	@Consumes("application/json")
	public void add(TaskPK t) {
		Task t1 =new Task();
		taskBusinessLocal.ajouterTask(t1,t);
	}
	
	@PUT
	@Path("/updateTask")
	@Consumes("application/json")
	public void update(TaskPK t) {
		Task t1 =new Task();
		taskBusinessLocal.modifierTask(t1,t);
	}
	@DELETE
	@Path("/deleteTask")
	@Consumes("application/json")
	public void remove(TaskPK t){
		Task t1 =new Task();
		taskBusinessLocal.supprimerTask(t1,t);
	}
	
	@GET
	@Path("/findAllOrganizerTasks/{id}")
	@Produces("application/json")
	public List<Task> getAllOrganizerTasks(@PathParam("id") Integer id) {
		return taskBusinessLocal.findAllOrganizerTasks(id);
		
	}
	
	@GET
	@Produces("application/json")
	public List<Task> getAllTasks() {
		return taskBusinessLocal.findAllTasks();
		
	}
	
	@GET
	@Path("/findAllEventTasks/{id}")
	@Produces("application/json")
	public List<Task> getAllEventTasks(@PathParam("id") Integer id) {
		return taskBusinessLocal.findAllEventTasks(id);
		
	}
	


}
