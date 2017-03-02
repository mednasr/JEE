package evpro.edu.esprit.interfaces;


import java.util.List;

import javax.ejb.Local;

import evpro.edu.esprit.persistance.Event;
import evpro.edu.esprit.persistance.Participant;


//@Remote : permet un accès à l'EJB depuis un client hors de la JVM
@Local// permet un accès à l'EJB depuis un client dans la même JVM que celle de l'EJB
public interface IParticipantBusinessLocal {


	public void add(Participant participant);

    public Participant find(Integer idUser);

	public void update(Participant participant);

	public void delete(Participant participant);


	public List<Event> findAllParticipantEvents(Integer idUser);

	List<Participant> findAllParticipant();
}
