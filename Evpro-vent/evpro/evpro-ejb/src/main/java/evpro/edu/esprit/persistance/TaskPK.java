package evpro.edu.esprit.persistance;

import java.io.Serializable;
import java.sql.Date;


import javax.persistence.*;

/**
 * Entity implementation class for Entity: TaskPK
 *
 */

@Embeddable
public class TaskPK implements Serializable {
    
	@GeneratedValue
	private Integer id;
	private Integer idEvent;
	private Integer idOrgnizer;
	private Date StartTask;
	private Date DeadLineTask;
	private String Description;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(Integer idEvent) {
		this.idEvent = idEvent;
	}

	public Integer getIdOrgnizer() {
		return idOrgnizer;
	}

	public void setIdOrgnizer(Integer idOrgnizer) {
		this.idOrgnizer = idOrgnizer;
	}

	public Date getStartTask() {
		return StartTask;
	}

	public void setStartTask(Date startDate) {
		StartTask = startDate;
	}

	public Date getDeadLineTask() {
		return DeadLineTask;
	}

	public void setDeadLineTask(Date deadLineTask) {
		DeadLineTask = deadLineTask;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DeadLineTask == null) ? 0 : DeadLineTask.hashCode());
		result = prime * result + ((Description == null) ? 0 : Description.hashCode());
		result = prime * result + ((StartTask == null) ? 0 : StartTask.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idEvent == null) ? 0 : idEvent.hashCode());
		result = prime * result + ((idOrgnizer == null) ? 0 : idOrgnizer.hashCode());
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
		TaskPK other = (TaskPK) obj;
		if (DeadLineTask == null) {
			if (other.DeadLineTask != null)
				return false;
		} else if (!DeadLineTask.equals(other.DeadLineTask))
			return false;
		if (Description == null) {
			if (other.Description != null)
				return false;
		} else if (!Description.equals(other.Description))
			return false;
		if (StartTask == null) {
			if (other.StartTask != null)
				return false;
		} else if (!StartTask.equals(other.StartTask))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idEvent == null) {
			if (other.idEvent != null)
				return false;
		} else if (!idEvent.equals(other.idEvent))
			return false;
		if (idOrgnizer == null) {
			if (other.idOrgnizer != null)
				return false;
		} else if (!idOrgnizer.equals(other.idOrgnizer))
			return false;
		return true;
	}

	private static final long serialVersionUID = 1L;

	public TaskPK() {
		super();
	}
   
}
