package evpro.edu.esprit.persistance;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: Reward
 *
 */
@Entity

public class Reward implements Serializable {

	private Integer id;
	private String description;
	private Participant participant;
	private Event event;

	@OneToOne(mappedBy = "rewardP")
	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	@OneToOne(mappedBy="reward")
	
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private static final long serialVersionUID = 1L;

	public Reward() {
		super();
	}

}
