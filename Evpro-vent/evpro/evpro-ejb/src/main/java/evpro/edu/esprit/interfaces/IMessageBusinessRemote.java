package evpro.edu.esprit.interfaces;

import java.util.List;

import javax.ejb.Remote;

import evpro.edu.esprit.persistance.Message;
import evpro.edu.esprit.persistance.Orgnizer;
import evpro.edu.esprit.persistance.User;




@Remote
public interface IMessageBusinessRemote {

void supprimerMessage(Message  mesg);
	
	Message chercherMessage(Integer id);
	
	List<Message> findmesgbyuser(Integer iduser);
	List<Message> findmesgbydest(Integer iduser);

	void ajouterMessage(Message msg);

	List<Message> findbylogin(String lastname);

	String findmesgbydate(Integer iduser ,Integer iddest);

	List<Message> findAllMessage();
}
