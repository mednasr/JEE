package evpro.edu.esprit.persistance;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: SatisfactionSurvey
 *
 */
@Entity
public class SatisfactionSurvey implements Serializable {

	private Integer idSurvey;
	private String creationDate;
	private String descreptiveText;
	private boolean status;
	private String messageInfo;
	private Event idEvent;
	private Participant idParticipant;

	public SatisfactionSurvey() {
		 
	}

	public SatisfactionSurvey(Integer idSurvey, String creationDate, String descreptiveText, boolean status,
			String messageInfo, Event idEvent, Participant idParticipant) {
		super();
		this.idSurvey = idSurvey;
		this.creationDate = creationDate;
		this.descreptiveText = descreptiveText;
		this.status = status;
		this.messageInfo = messageInfo;
		this.idEvent = idEvent;
		this.idParticipant = idParticipant;
	}

	public String getMessageInfo() {
		return messageInfo;
	}

	public void setMessageInfo(String messageInfo) {
		this.messageInfo = messageInfo;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	private static final long serialVersionUID = 1L;

	//////////////////
	@JoinColumn(insertable = true, name = "idParticipant", referencedColumnName = "idUser")
	@ManyToOne()
	public Participant getIdParticipant() {
		return idParticipant;
	}

	public void setIdParticipant(Participant idParticipant) {
		this.idParticipant = idParticipant;
	}
	////////////////////

	///////////////
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdSurvey() {
		return this.idSurvey;
	}

	public void setIdSurvey(Integer idSurvey) {
		this.idSurvey = idSurvey;
	}

	/////////////////
	@ManyToOne()
	@JoinColumn(name = "idEvent_fk")
	public Event getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(Event idEvent) {
		this.idEvent = idEvent;
	}

	/////////////////
	public String getDescreptiveText() {
		return this.descreptiveText;
	}

	public void setDescreptiveText(String descreptiveText) {
		this.descreptiveText = descreptiveText;
	}

}
