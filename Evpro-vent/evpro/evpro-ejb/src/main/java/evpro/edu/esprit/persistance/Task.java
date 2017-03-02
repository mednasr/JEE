package evpro.edu.esprit.persistance;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Task implements Serializable{
	
	

	private static final long serialVersionUID = 1L;
	private TaskPK taskPK;
	private Event event;
	private Orgnizer orgnizer;
	
	
	public Task(TaskPK taskPK) {
		super();
		this.taskPK = taskPK;
	}
	
	
	public Task(TaskPK taskPK, Event event, Orgnizer orgnizer) {
		super();
		this.taskPK = taskPK;
		this.event = event;
		this.orgnizer = orgnizer;
	}
	
	
	public Task() {
		super();
	}
	
	
	public Task(TaskPK taskPK, Event event) {
		super();
		this.taskPK = taskPK;
		this.event = event;
	}


	@EmbeddedId
	public TaskPK getTaskPK() {
		return taskPK;
	}
	public void setTaskPK(TaskPK taskPK) {
		this.taskPK = taskPK;
	}
	
	//////////////////////////

	@ManyToOne
	@JoinColumn(insertable= false, updatable= false, name="idEvent" ,referencedColumnName="idEvent")
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	
	//////////////////

	@ManyToOne
	@JoinColumn(insertable= false, updatable= false, name="idOrgnizer" ,referencedColumnName="idUser")
	public Orgnizer getOrgnizer() {
		return orgnizer;
	}
	public void setOrgnizer(Orgnizer orgnizer) {
		this.orgnizer = orgnizer;
	}
	@Override
	public String toString() {
		return "Task [taskPK=" + taskPK + ", event=" + event + ", orgnizer=" + orgnizer + "]";
	}
	
	
	
	
	
	
	

}
