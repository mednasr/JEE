package evpro.edu.esprit.business;

import java.awt.peer.LightweightPeer;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.Null;

import evpro.edu.esprit.interfaces.IMessageBusinessLocal;
import evpro.edu.esprit.interfaces.IMessageBusinessRemote;
import evpro.edu.esprit.persistance.Message;
import evpro.edu.esprit.persistance.Orgnizer;
import evpro.edu.esprit.persistance.Participant;
import evpro.edu.esprit.persistance.User;

@Stateless
public class MessageBusiness implements IMessageBusinessLocal,IMessageBusinessRemote {

	@PersistenceContext(unitName = "evpro-ejb")
	EntityManager em;

	@Override
	public void ajouterMessage(Message msg) {
		
		if (msg.getId_destinataire()==null){
			System.out.println("wearning message va étre envoyer a un destinataire");}
			else {
				em.persist(msg);
			}
		}
		

	@Override
	public List<Message> findAllMessage() {
		return em
				.createQuery("select m from Message m", Message.class)
				.getResultList();

	}

	@Override
	public void modifierMessage(Message msg) {
		em.merge(msg);

	}

	@Override
	public void supprimerMessage(Message msg) {
		em.remove(em.merge(msg));

	}

	@Override
	public Message chercherMessage(Integer id) {
		return em.find(Message.class, id);

	}

	@Override
	public List<Message> findmesgbyuser(Integer iduser) {
		List<Message> msgs = em.createQuery("select m from Message m  where m.orgnizer.idUser=:Id", Message.class)
				.setParameter("Id", iduser).getResultList();
		return msgs;
	}

	@Override
	public List<Message> findmesgbydest(Integer iduser) {
		List<Message> msgs = em.createQuery("select m from Message m where m.id_destinataire=:Id")
				.setParameter("Id", iduser).getResultList();
		for (Message o : msgs){
			o.setStatut(1);
		}
		
		return msgs;
	}

	@Override
	public List<Message> findbylogin(String lastname) {
		List<Message> msgs = em.createQuery("select m from Message as m  where m.orgnizer=(select o from Orgnizer as o where o.lastName=:lastname)", Message.class)
				.setParameter("lastname",lastname).getResultList();
        return msgs;
	}
	@Override
	public String findmesgbydate(Integer iduser,Integer iddest) {
		String Newligne=System.getProperty("line.separator"); 
		String khalil="";
		List<Message> msgs = em.createQuery("select m from Message m where m.id_destinataire=:Id OR m.orgnizer.idUser=:Id ORDER BY m.date", Message.class)
				.setParameter("Id", iduser).getResultList();
		for (Message o : msgs){ //Pour afficher toute ta liste
			
			
			if(o.getOrgnizer().getIdUser()==iddest || o.getId_destinataire()==iddest){
			if (o.getOrgnizer().getIdUser()==iduser){
				if(o.getStatut()==1){
				khalil=khalil+("MOI"+Newligne+o.getDescription()+Newligne+"****vu****"+Newligne);
				}
				else {
					khalil=khalil+("MOI"+Newligne+o.getDescription()+Newligne);
				}
				
			}
			else if(o.getOrgnizer().getIdUser()!=iduser) {
				khalil=khalil+(o.getOrgnizer().getFirstName()+Newligne+o.getDescription()+Newligne);
			
			}
			}
			}
		return khalil;
		

		
		

		
	}


}
