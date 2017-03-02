package evpro.edu.esprit.persistance;

import java.io.Serializable;
import java.sql.Date;
import java.util.BitSet;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Entity implementation class for Entity: Event
 *
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Event implements Serializable {

	private Integer idEvent;
	private String name;
	private String description;
	private double longitude;
	private double laltitude;
	private String image;
	private String video;
	private Date eventStartingDate;
	private Date eventFinishingDate;
	private double price;
	private String cityAdress;
	private String countryAdress;
	private String tag;
	private String category;
	private String eventType;
	private String facebookEventLink;
	private String twitterEventLink;
	private String slogan;
	private List<Payment> Payments;
	private List<Comment> Comments;
	private EventOwner owner;
	private List<Feature> features;
	private List<Task> tasks;
	private Reward reward;
	private List<Participant> EventParticipants;
	private List<Orgnizer> orgnizerEvents;
	private List<SatisfactionSurvey> surveys;

	public Event(Integer idEvent) {
		super();
		this.idEvent = idEvent;
	}

	@Id
	public Integer getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(Integer idEvent) {
		this.idEvent = idEvent;
	}

	@JsonIgnore
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonIgnore
	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@JsonIgnore
	public double getLaltitude() {
		return laltitude;
	}

	public void setLaltitude(double laltitude) {
		this.laltitude = laltitude;
	}

	@Lob
	@JsonIgnore
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@JsonIgnore
	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	@JsonIgnore
	public Date getEventStartingDate() {
		return eventStartingDate;
	}

	public void setEventStartingDate(Date eventStartingDate) {
		this.eventStartingDate = eventStartingDate;
	}

	@JsonIgnore
	public Date getEventFinishingDate() {
		return eventFinishingDate;
	}

	public void setEventFinishingDate(Date eventFinishingDate) {
		this.eventFinishingDate = eventFinishingDate;
	}

	@JsonIgnore
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@JsonIgnore
	public String getCityAdress() {
		return cityAdress;
	}

	public void setCityAdress(String cityAdress) {
		this.cityAdress = cityAdress;
	}

	@JsonIgnore
	public String getCountryAdress() {
		return countryAdress;
	}

	public void setCountryAdress(String countryAdress) {
		this.countryAdress = countryAdress;
	}

	@JsonIgnore
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@JsonIgnore
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@JsonIgnore
	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	@JsonIgnore
	public String getFacebookEventLink() {
		return facebookEventLink;
	}

	public void setFacebookEventLink(String facebookEventLink) {
		this.facebookEventLink = facebookEventLink;
	}

	@JsonIgnore
	public String getTwitterEventLink() {
		return twitterEventLink;
	}

	public void setTwitterEventLink(String twitterEventLink) {
		this.twitterEventLink = twitterEventLink;
	}

	@JsonIgnore
	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	////////////////////////
	@ManyToOne(fetch = FetchType.EAGER)
	@XmlTransient
	public EventOwner getOwner() {
		return owner;
	}

	public void setOwner(EventOwner owner) {
		this.owner = owner;
	}

	//////////////////////////////////
	@XmlTransient
	@ManyToMany
	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

	////////////////////////////////

	@OneToMany(mappedBy = "event")
	@JsonIgnore
	@XmlTransient
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public void assignTaskToThisEvent(List<Task> tasks) {
		this.setTasks(tasks);
		for (Task t : tasks) {
			t.setEvent(this);
		}
	}
	//////////////////////////////////////

	@OneToOne(fetch = FetchType.LAZY)
	@XmlTransient
	public Reward getReward() {
		return reward;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}

	private static final long serialVersionUID = 1L;

	public Event() {
		super();
	}

	///////////////////////////////

	@ManyToMany
	@XmlTransient
	// @JoinColumn(insertable = true, updatable = true, name = "idPaticipants",
	// referencedColumnName = "idUser")
	public List<Participant> getEventParticipants() {
		return EventParticipants;
	}

	public void setEventParticipants(List<Participant> EventParticipants) {
		this.EventParticipants = EventParticipants;
	}

	//////////////////////////////// 7
	@OneToMany(mappedBy = "eventComments")
	@JsonIgnore
	@XmlTransient
	public List<Comment> getComments() {
		return Comments;
	}

	public void setComments(List<Comment> comments) {
		Comments = comments;
	}

	public void addCommentsToThisEvent(List<Comment> Comments) {
		this.setComments(Comments);
		for (Comment c : Comments) {
			c.setEventComments(this);
		}
	}

	///////////////////////////////
	@OneToMany(mappedBy = "eventPayment")
	@JsonIgnore
	@XmlTransient
	public List<Payment> getPayments() {
		return Payments;
	}

	public void setPayments(List<Payment> payments) {
		Payments = payments;
	}

	public void addPaymentToThisEvent(List<Payment> Payments) {
		this.setPayments(Payments);
		for (Payment p : Payments) {
			p.setEventPayment(this);
		}
	}

	/////////////////////////
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(insertable = true, updatable = true, name = "idOrgnizer", referencedColumnName = "idUser")
	@XmlTransient
	public List<Orgnizer> getOrgnizerEvents() {
		return orgnizerEvents;
	}

	public void setOrgnizerEvents(List<Orgnizer> orgnizerEvents) {
		this.orgnizerEvents = orgnizerEvents;
	}

	////////////////////////////////

	@OneToMany(mappedBy = "idEvent", fetch = FetchType.LAZY)
	@JsonIgnore
	@XmlTransient
	public List<SatisfactionSurvey> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<SatisfactionSurvey> surveys) {
		this.surveys = surveys;
	}

	/////////////////////

}
