package evpro.edu.esprit.persistance;

import evpro.edu.esprit.persistance.User;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Orgnizer
 *
 */
@Entity

public class Orgnizer extends User implements Serializable {

	private float rating;
	private List<Message> msg;
	private List<Task> tasks;
	private List<Event> Events;
	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public Orgnizer(Integer idUser,List<Event> events) {
		super(idUser);

				Events = events;
	}
	/////////////
	
	@XmlTransient
	
	@OneToMany(mappedBy="orgnizer",fetch = FetchType.LAZY)
	public List<Message> getMsg() {
		return msg;
	}

	public void setMsg(List<Message> msg) {
		this.msg = msg;
	}

	////////////

	@JsonIgnore
	@OneToMany(mappedBy = "orgnizer",fetch=FetchType.LAZY)
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public void assignTaskToThisOrgnizer(List<Task> tasks) {
		this.setTasks(tasks);
		for (Task t : tasks) {
			t.setOrgnizer(this);
		}
	}
	@JsonIgnore
	@ManyToMany(mappedBy = "orgnizerEvents")
	public List<Event> getEvents() {
		return Events;
	}

	public void setEvents(List<Event> events) {
		Events = events;
	}

	//////

	private static final long serialVersionUID = 1L;

	public Orgnizer() {
		super();
	}


}
