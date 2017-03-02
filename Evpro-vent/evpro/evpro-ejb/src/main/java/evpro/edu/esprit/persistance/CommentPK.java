package evpro.edu.esprit.persistance;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CommentPK implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idEvent;
	private Integer idParticipant;
	@Override
	public int hashCode() {
		final Integer prime = 31;
		Integer result = 1;
		result = prime * result + idEvent;
		result = prime * result + idParticipant;
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
		CommentPK other = (CommentPK) obj;
		if (idEvent != other.idEvent)
			return false;
		if (idParticipant != other.idParticipant)
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
