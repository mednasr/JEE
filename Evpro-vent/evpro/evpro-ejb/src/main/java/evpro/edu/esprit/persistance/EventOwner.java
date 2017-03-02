package evpro.edu.esprit.persistance;

import evpro.edu.esprit.persistance.User;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: EventOwner
 *
 */
@Entity

public class EventOwner extends User implements Serializable {
	
	

	
	private static final long serialVersionUID = 1L;

	public EventOwner() {
		super();
	}
   
}
