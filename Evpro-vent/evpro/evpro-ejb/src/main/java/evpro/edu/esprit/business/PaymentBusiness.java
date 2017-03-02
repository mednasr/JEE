package evpro.edu.esprit.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import evpro.edu.esprit.interfaces.IEventBusinessLocal;
import evpro.edu.esprit.interfaces.IParticipantBusinessLocal;
import evpro.edu.esprit.interfaces.IPaymentBusinessLocal;
import evpro.edu.esprit.persistance.Comment;
import evpro.edu.esprit.persistance.Event;
import evpro.edu.esprit.persistance.Participant;
import evpro.edu.esprit.persistance.Payment;


/**
 * Session Bean implementation class PaymentService
 */
@Stateless //c'est le nom de la classe de l'EJB deux clients peuvent acceder a la meme instance
@LocalBean  //using @LocalBean and using no annotation at all are both ways of getting a no-interface view
public class PaymentBusiness implements IPaymentBusinessLocal {

	@PersistenceContext(unitName="evpro-ejb")
	private EntityManager em;
	@EJB
	private IEventBusinessLocal eventbusiness;
	@EJB
	private IParticipantBusinessLocal participantbusiness;
	
    public PaymentBusiness() {
    }


    	public void add(Payment payment) {
    		em.persist(em.merge(payment));
    	}

    	public void delete(Payment payment) {
    		em.remove(em.merge(payment));
    	}


    	public void update(Payment payment) {
    		em.merge(payment);
    	}

    	public Payment find(Integer id) {

    		return em.find(Payment.class, id);
    	}
    	
    	@Override
  	   public List<Payment> findAllPayments()
  	    {
  		List<Payment> payment = (List<Payment>) em.createQuery(

  				"SELECT new Payment(p.idPayment,p.paymentStatus,p.paymentAmount,participant,"
  				+ "event) "
  				+ "FROM Payment p JOIN p.participantPayment participant "
  				+ "JOIN p.eventPayment event",Payment.class).getResultList();

  		for (Payment payments : payment)
  		  {


      		Event event = eventbusiness.find(payments.getEventPayment().getIdEvent()); //(EventParticipants.getEvent().getId());
      		payments.setEventPayment(event); /* A VERIFIER POUR GETALLEVENT WITHOUT BLOCKING THE REST OF DISPLAY */

  	        Participant participant = participantbusiness.find(payments.getParticipantPayment().getIdUser()) ;
  	      payments.setParticipantPayment(participant);
  		  }

          return payment;
  	    }
    	
    	  @Override
      public List<Payment> findEventPayments(Integer id)
      {
    	  List<Payment> Payments = null;
			String jpql = "select p from Payment p where p.eventPayment.idEvent=:x";
			TypedQuery<Payment> query = em.createQuery(jpql,Payment.class);
			query.setParameter("x", id);
			Payments = query.getResultList();
			return Payments;
			
		}

            @Override
  	public void CancelPayment(Payment payment) {

  		if(payment.getPaymentStatus()!="canceled")
  		{
  			payment.setPaymentStatus("canceled");
  			em.merge(payment);
  		}
}


      public String PaymentPoucentage(int idEvent){
  		float Percentage=0;
  		String LabelPercentage=null;
  		List<Payment> ApprovedPayments;
  		List<Payment> AllPayments;
  		int NbrApprovedPayments=0;
  		int NbrAllPayments=0;
  		String ApprovedPaymentsQuery="select p from Payment p where p.eventPayment.idEvent = :id and p.paymentStatus='Done'";
  		TypedQuery <Payment> query = em.createQuery(ApprovedPaymentsQuery, Payment.class);
  		query.setParameter("id", idEvent);
  		ApprovedPayments = query.getResultList();

  		for(Payment payment:ApprovedPayments){
  			NbrApprovedPayments ++;

  	     }
  		String AllPaymentsQuery="select p from Payment p where p.eventPayment.idEvent=:id";
  		TypedQuery <Payment> query2 = em.createQuery(AllPaymentsQuery, Payment.class);
  		query2.setParameter("id", idEvent);
  		AllPayments = query2.getResultList();

  		for(Payment payment:AllPayments){
  			NbrAllPayments ++;

  	     }
  		Percentage = (100*NbrAllPayments)/NbrApprovedPayments;
  		return LabelPercentage = Percentage+"%";
  	}
}
