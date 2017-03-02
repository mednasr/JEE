package evpro.edu.esprit.ressources;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import evpro.edu.esprit.interfaces.ISatisfactionSurveyLocal;
import evpro.edu.esprit.persistance.SatisfactionSurvey;

@Path("satisfactionSurvey")
@RequestScoped

public class SatisfactionSurveyRessource {
	@EJB
	ISatisfactionSurveyLocal satSurLocal;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllSurveys() {

		return Response.status(Status.OK).entity(satSurLocal.FindAllSurveys()).build();

	}

	@GET
	@Path("/countSurveysPerParticipant/{idPArticipant}")
	@Produces("application/json")
	public Response countSurveyPerParticipant(@PathParam("idPArticipant") int idParticipant) {

		long nbrSurveys = satSurLocal.countSurveyPerParticipant(idParticipant);

		if (nbrSurveys == 0)
			return Response.status(Status.NOT_FOUND).entity("No surveys Found").build();
		else
			return Response.ok(nbrSurveys).build();

	}

	@GET
	@Path("/countSurveysPerEvent/{idEvent}")
	@Produces("application/json")
	public Response countSurveyPerIdEvent(@PathParam("idEvent") int idEvent) {

		long nbrSurveys = satSurLocal.countSurveyPerParticipant(idEvent);

		if (nbrSurveys == 0)
			return Response.status(Status.NOT_FOUND).entity("No surveys Found").build();
		else
			return Response.ok(nbrSurveys).build();

	}

	@POST
	@Path("/addSurvey")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public void AddSurvey(SatisfactionSurvey survey) {
		satSurLocal.addSatisfactionSurey(survey);

	}

	@POST
	@Path("/sendSms/{message}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String AddSurvey(@PathParam("message") String messagInfo) {
		satSurLocal.SendMessageApi(messagInfo);
		return "message sent !!! your message is" + messagInfo;

	}

	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public void RemoveSatisfaction(SatisfactionSurvey st) {
		satSurLocal.RemoveSatisfactionSurvey(st);
	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void AddSatisfaction(SatisfactionSurvey sat) {
		satSurLocal.addSatisfactionSurey(sat);
	}

	@GET
	@Path("/countAllSurveys")
	@Produces(MediaType.TEXT_PLAIN)
	public Response countAllSurvey() {

		long nbrSurveys = satSurLocal.countAllSurvey();

		if (nbrSurveys == 0)
			return Response.status(Status.NOT_FOUND).entity("No surveys Found").build();
		else
			return Response.ok(nbrSurveys).build();
	}

	
	@GET
	@Path("/AllSurveys")
	@Produces(MediaType.TEXT_PLAIN)
	public int PercentSurveysResponse() {
		return satSurLocal.participantResponds();
		
		
		
		
		
		 


		 

	}
	
}
