package evpro.edu.esprit.interfaces;

import java.util.List;

import javax.ejb.Remote;

import evpro.edu.esprit.persistance.Participant;
@Remote
public interface IParticipantBusinessRemote {


	public void add(Participant participant);

    public Participant find(Integer id);

	public void update(Participant participant);

	public void delete(Participant participant);
	
	public List<Participant> getAllParticipants();
	
	public List<Participant> findAllParticipantEvents(Integer id);
}
