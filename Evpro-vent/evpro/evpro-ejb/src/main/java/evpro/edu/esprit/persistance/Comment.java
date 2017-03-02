package evpro.edu.esprit.persistance;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Comment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private Date StartComment;
	private CommentPK idComment;
	private Event eventComments;
	private Participant participantComments;



	public Comment() {
		super();
	}
	public Comment(CommentPK idComment) {
		super();
		this.idComment = idComment;
	}
	public Comment( CommentPK idComment, Event eventComments,
			Participant participantComments) {
		super();

		this.idComment = idComment;
		this.eventComments = eventComments;
		this.participantComments = participantComments;
	}

	public Comment(String message, CommentPK idComment, Event eventComments, Participant participantComments) {
		super();
		this.message = message;
		this.idComment = idComment;
		this.eventComments = eventComments;
		this.participantComments = participantComments;
	}
	public Comment(String message, CommentPK idComment) {
		super();
		this.message = message;
		this.idComment = idComment;
	}
	public Date getStartComment() {
		return StartComment;
	}
	public void setStartComment(Date startComment) {
		StartComment = startComment;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@EmbeddedId
	public CommentPK getIdComment() {
		return idComment;
	}
	public void setIdComment(CommentPK idComment) {
		this.idComment = idComment;
	}


////////////////////////////////

	@ManyToOne
	@JoinColumn(insertable = false, updatable = false ,name = "idEvent" , referencedColumnName = "idEvent")
	public Event getEventComments() {
		return eventComments;
	}
	public void setEventComments(Event eventComments) {
		this.eventComments = eventComments;
	}


////////////////////////////////////

	@ManyToOne
	@JoinColumn(insertable = false, updatable = false ,name = "idParticipant" , referencedColumnName = "idUser")
	public Participant getParticipantComments() {
		return participantComments;
	}

	public void setParticipantComments(Participant participantCommentsid) {
		this.participantComments = participantCommentsid;
	}
}
