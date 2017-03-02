package util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import evpro.edu.esprit.interfaces.IPaymentBusinessLocal;
import evpro.edu.esprit.persistance.Payment;

@Startup
@Singleton
public class Test {

	@EJB
	IPaymentBusinessLocal businessLocal;

	@PostConstruct
	public void test(){
		/*System.out.println("test!!!!!!!!!!!!!!!");
		List<Payment> payments = new ArrayList<Payment>();
			payments=	businessLocal.findEventPayments(1);
		for (Payment payment : payments) {
		System.out.println(payment.getPaymentStatus());
		System.out.println(payment.getPaymentDate());
		System.out.println(payment.getEventPayment().getIdEvent());
		}*/
	}
}