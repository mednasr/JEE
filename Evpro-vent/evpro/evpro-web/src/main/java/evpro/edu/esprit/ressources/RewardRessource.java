package evpro.edu.esprit.ressources;

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
import javax.ws.rs.core.MediaType;

import evpro.edu.esprit.interfaces.IRewardBusinessLocal;
import evpro.edu.esprit.persistance.Reward;

@Path("/reward")
@RequestScoped
public class RewardRessource {
	@EJB
	IRewardBusinessLocal rewardBusinessLocal;

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void ajouterReward(Reward reward) {
		rewardBusinessLocal.ajouterReward(reward);
	}

	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public void supprimerReward(Reward reward) {

		rewardBusinessLocal.supprimerReward(reward);
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String modifierReward(Reward reward) {
		if (rewardBusinessLocal.rewardExist(reward.getId()) == false) {
			rewardBusinessLocal.modifierReward(reward);
			return "modifié";
		}
		else
		return "Reward inexistant";

	}

	@GET
	@Path("/exist/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String existReward(@PathParam("id") int id) {
		if (rewardBusinessLocal.rewardExist(id) == false) {
			return "exist";
		}

		else
			return "does not exist please verify id";

	}

	@GET
	@Path("/find/{id}")
	@Produces("application/json")
	public Reward chercherReward(@PathParam("id") Integer id) {

		return rewardBusinessLocal.chercherReward(id);
	}

}
