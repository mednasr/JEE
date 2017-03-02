package evpro.edu.esprit.persistance;

import java.io.Serializable;

import java.lang.String;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
/**
 * Entity implementation class for Entity: Participant
 *
 */

@Entity
@Table(name="Participant")
public class Participant extends User implements Serializable {


	private List<SatisfactionSurvey>surveys;
	private Reward rewardP;
	private List<Comment> Comments;
	private List<Payment> Payments;
	private List<Event> Events;



	private static final long serialVersionUID = 1L;
	public Participant() {

	}

	public Participant(Integer idUser, Reward rewardP) {
		super(idUser);
		this.rewardP = rewardP;

	}

	public Participant(Integer idUser) {
		super(idUser);
	}

	public Participant(Integer idUser, List<SatisfactionSurvey> surveys, Reward rewardP,
			List<Comment> comments, List<Payment> payments, List<Event> events) {
		super(idUser);

		this.surveys = surveys;
		this.rewardP = rewardP;
		Comments = comments;
		Payments = payments;
				Events = events;
	}




	///////////////////////

	@OneToOne(fetch = FetchType.LAZY)
	@XmlTransient
	public Reward getRewardP() {
		return rewardP;
	}

	public void setRewardP(Reward rewardP) {
		this.rewardP = rewardP;
	}

///////////////////////

	@OneToMany(mappedBy = "participantComments")
	@JsonIgnore
	@XmlTransient
	public List<Comment> getComments() {
		return Comments;
	}
	public void setComments(List<Comment> Comments) {
		this.Comments = Comments;
	}

	public void addCommentsToThisParticipant(List<Comment> Comments)
	{
		this.setComments(Comments);
		for(Comment c : Comments)
		{
			c.setParticipantComments(this);
		}
	}
	/////////////////////////

	// @XmlTransient

	@OneToMany( mappedBy = "participantPayment")
	@JsonIgnore
	@XmlTransient
	public List<Payment> getPayments() {
		return Payments;
	}

	public void setPayments(List<Payment> payments) {
		Payments = payments;
	}


	public void addPaymentToThisParticipant(List<Payment> Payments)
	{
		this.setPayments(Payments);
		for(Payment p : Payments)
		{
			p.setParticipantPayment(this);
		}
	}
    /////////////////////////
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "idParticipant")
	@JsonIgnore
	@XmlTransient
	public List<SatisfactionSurvey> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<SatisfactionSurvey> surveys) {
		this.surveys = surveys;
	}


	///////////////


	@ManyToMany(mappedBy = "eventParticipants",fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@XmlTransient
	public List<Event> getEvents() {
		return Events;
	}

	public void setEvents(List<Event> Events) {
		this.Events = Events;
	}

	////////////////////



}
