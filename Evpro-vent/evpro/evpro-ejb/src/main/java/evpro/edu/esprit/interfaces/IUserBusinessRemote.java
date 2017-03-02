package evpro.edu.esprit.interfaces;

import java.util.List;

import javax.ejb.Remote;

import evpro.edu.esprit.persistance.User;

@Remote
public interface IUserBusinessRemote {

	void ajouterUser(User user);
	
	void modifierUser(User user);
	
	void supprimerUser(User user);
	
 List<User> findAllUsers();
 
 User authentificate(String mail, String password);
	
	//User chercherUser(Integer id);

}
