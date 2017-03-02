package evpro.edu.esprit.interfaces;


import java.util.List;

import javax.ejb.Local;

import evpro.edu.esprit.persistance.Participant;
import evpro.edu.esprit.persistance.Payment;



//@Remote : permet un accès à l'EJB depuis un client hors de la JVM
@Local// permet un accès à l'EJB depuis un client dans la même JVM que celle de l'EJB
public interface IPaymentBusinessLocal {

	public void add(Payment payment);

	public void delete(Payment payment);

	public void update(Payment payment);

	public Payment find(Integer id);

   public String PaymentPoucentage(int idEvent);

	public List<Payment> findEventPayments(Integer id);
	 public List<Payment> findAllPayments();
	void CancelPayment(Payment payment);



}
