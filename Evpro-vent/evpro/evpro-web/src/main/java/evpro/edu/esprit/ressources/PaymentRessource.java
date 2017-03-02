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

import evpro.edu.esprit.interfaces.ICommentBusinessLocal;
import evpro.edu.esprit.interfaces.IPaymentBusinessLocal;
import evpro.edu.esprit.persistance.Comment;
import evpro.edu.esprit.persistance.Payment;

@Path("payment")
@RequestScoped
public class PaymentRessource {

	@Inject
	IPaymentBusinessLocal paymentBusinessLocal;

	
	
	
	@POST
	@Path("/add")
	@Consumes("application/json")
	public void add(Payment payment) {
		paymentBusinessLocal.add(payment);
	}

	@GET
	@Path("/find/{id}")
	@Produces("application/json")
	public Payment find(@PathParam("id") Integer id) {

		return paymentBusinessLocal.find(id);

	}
	
	@PUT
    @Path("/update")
	@Consumes("application/json")
    public void update(Payment payment)
	{
		paymentBusinessLocal.update(payment);
	}
	
	@DELETE
	@Path("/delete")
	@Consumes("application/json")
	public void delete(Payment payment) {

		paymentBusinessLocal.delete(payment);

	}

	@GET
	@Path("/findEventPayments/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Payment> getAllEventPayments(@PathParam("id") Integer id) {
		
		return paymentBusinessLocal.findEventPayments(id);
		
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPayments() {

		return Response.status(Status.FOUND).entity(paymentBusinessLocal.findAllPayments()).build();

	}

	@PUT
    @Path("/cancel")
	@Consumes("application/json")
    public void CancelPayment(Payment payment)
	{
		paymentBusinessLocal.CancelPayment(payment);
	}
	
	
	@GET
	@Path(value="/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response PaymentPoucentage(@PathParam(value="id")int idEvent ) {
  
		String Percentage=paymentBusinessLocal.PaymentPoucentage(idEvent);
		
		if (Percentage==null)
			return Response.status(Status.NOT_FOUND).entity("No Payments Fouidd").build();
		else
			return Response.ok(Percentage).build();

	}
	
}
