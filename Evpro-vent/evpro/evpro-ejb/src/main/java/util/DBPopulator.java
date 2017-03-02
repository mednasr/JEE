package util;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import evpro.edu.esprit.interfaces.IParticipantBusinessLocal;
import evpro.edu.esprit.persistance.Participant;

@Singleton
@Startup
public class DBPopulator {

	@EJB
	IParticipantBusinessLocal businessLocal;
	@PostConstruct
	public void init(){
		Participant p = new Participant();
		//p= businessLocal.find(1);
		System.out.println(p.getIdUser());
	}
	
}
