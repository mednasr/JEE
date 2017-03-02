package evpro.edu.esprit.persistance;

import java.io.Serializable;

import javax.persistence.Embeddable;



@Embeddable
public class PaymentPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idEvent;
	private Integer idParticipant;
	
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEvent == null) ? 0 : idEvent.hashCode());
		result = prime * result + ((idParticipant == null) ? 0 : idParticipant.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentPK other = (PaymentPK) obj;
		if (idEvent == null) {
			if (other.idEvent != null)
				return false;
		} else if (!idEvent.equals(other.idEvent))
			return false;
		if (idParticipant == null) {
			if (other.idParticipant != null)
				return false;
		} else if (!idParticipant.equals(other.idParticipant))
			return false;
		return true;
	}
	public Integer getIdEvent() {
		return idEvent;
	}
	public void setIdEvent(Integer idEvent) {
		this.idEvent = idEvent;
	}
	public Integer getIdParticipant() {
		return idParticipant;
	}
	public void setIdParticipant(Integer idParticipant) {
		this.idParticipant = idParticipant;
	}
	

}
