package evpro.edu.esprit.persistance;

import java.io.Serializable;

import java.util.Date;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;



/**
 * Entity implementation class for Entity: Message
 *
 */
@Entity
public class Message implements Serializable {


	private Integer id ;
	private  String description ; 
	private Date date ;
	private Integer statut ;
	
	

	private Integer id_destinataire ;
	private Orgnizer orgnizer; 
	
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	//////////////////////////////



	@JoinColumn(insertable = true, name = "orgnizer", referencedColumnName = "idUser")
	@ManyToOne(fetch=FetchType.EAGER)
	
	public Orgnizer getOrgnizer() {
		return orgnizer;
	}

	public void setOrgnizer(Orgnizer orgnizer) {
		this.orgnizer = orgnizer;
	}
////////////////////////////////////
	public Message() {
		super();
	}
	

	public Message(Integer id, Orgnizer orgnizer, String description, Date date, Integer id_destinataire) {
		super();
		this.id = id;
		this.orgnizer = orgnizer;
		this.description = description;
		this.date = date;
		this.id_destinataire = id_destinataire;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getId_destinataire() {
		return id_destinataire;
	}

	public void setId_destinataire(Integer id_destinataire) {
		this.id_destinataire = id_destinataire;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getStatut() {
		return statut;
	}

	public void setStatut(Integer statut) {
		this.statut = statut;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", description=" + description + ", date=" + date + ", statut=" + statut
				+ ", id_destinataire=" + id_destinataire + "]";
	}

	

	

	

	
	

	
}
