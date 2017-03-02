package evpro.edu.esprit.persistance;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
	
/**
 * Entity implementation class for Entity: Feature
 *
 */
@Entity

public class Feature implements Serializable {
                 
				private Integer id;
				private String Feature;
				private String logo;
				private List <Event>events;
		     @Id
             public Integer getId() 
                {
					return id;
				}

				public void setId(Integer id) {
					this.id = id;
				}

				public String getFeature() {
					return Feature;
				}

				public void setFeature(String feature) {
					Feature = feature;
				}

				public String getLogo() {
					return logo;
				}

				public void setLogo(String logo) {
					this.logo = logo;
				}
				
				
				@ManyToMany(mappedBy="features")
				public List<Event> getEvents() {
					return events;
				}

				public void setEvents(List<Event> events) {
					this.events = events;
				}

private static final long serialVersionUID = 1L;

	public Feature() {
		super();
	}
   
}
