package evpro.edu.esprit.interfaces;

import java.util.List;

import javax.ejb.Remote;

import evpro.edu.esprit.persistance.Payment;
@Remote
public interface IPaymentBusinessRemote {
	public void add(Payment payment);

	public void delete(Payment payment);

	public void update(Payment payment);
	
	public Payment find(Integer id);
	
	public List<Payment> findParticipantPayments(Integer id);
}
