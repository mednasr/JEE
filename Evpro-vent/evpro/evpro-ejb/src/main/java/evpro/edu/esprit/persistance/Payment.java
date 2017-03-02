package evpro.edu.esprit.persistance;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * Entity implementation class for Entity: Payment
 *
 */

@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
public class Payment implements Serializable {
	
	@JsonIgnore
	private Event eventPayment;
	@JsonIgnore
	private Participant participantPayment;
	private PaymentPK idPayment;
	private Date paymentDate;
	private Integer paymentAmount;
	private String paymentStatus;
	
	private static final long serialVersionUID = 1L;
	
	
	


	
	public Payment( PaymentPK idPayment, String paymentStatus ,Integer paymentAmount, Participant participantPayment, Event eventPayment) {
		super();
		this.idPayment = idPayment;
		this.paymentStatus = paymentStatus;
		this.paymentAmount = paymentAmount;
		this.participantPayment = participantPayment;
		this.eventPayment = eventPayment;
	}
	public Payment( PaymentPK idPayment, String paymentStatus ,Integer paymentAmount) {
		super();
		this.idPayment = idPayment;
		this.paymentStatus = paymentStatus;
		this.paymentAmount = paymentAmount;
		
		
	}
	
	public Payment(Event eventPayment, PaymentPK idPayment) {
		super();
		this.eventPayment = eventPayment;
		this.idPayment = idPayment;
	}

	public Payment(PaymentPK idPayment) {
		super();
		this.idPayment = idPayment;
	}
	

	public Payment() {
		super();
	}

	@EmbeddedId
	public PaymentPK getIdPayment() {
		return idPayment;
	}

	public void setIdPayment(PaymentPK idPayment) {
		this.idPayment = idPayment;
	}

	


	public Date getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Date PaymentDate) {
		this.paymentDate = PaymentDate;
	}   
	public Integer getPaymentAmount() {
		return this.paymentAmount;
	}

	public void setPaymentAmount(Integer PaymentAmount) {
		this.paymentAmount = PaymentAmount;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

////////////////////////////

	
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @XmlTransient
	@JoinColumn(insertable = false, updatable = false ,name = "idEvent" , referencedColumnName = "idEvent")
	public Event getEventPayment() {
		return eventPayment;
	}


	public void setEventPayment(Event eventPayment) {
		this.eventPayment = eventPayment;
	}

	
/////////////////////////

	@ManyToOne
	@XmlTransient
	@JoinColumn(insertable = false, updatable = false ,name = "idParticipant" , referencedColumnName = "idUser")
	public Participant getParticipantPayment() {
		return participantPayment;
	}

	public void setParticipantPayment(Participant participantPayment) {
		this.participantPayment = participantPayment;
	}


   
}
