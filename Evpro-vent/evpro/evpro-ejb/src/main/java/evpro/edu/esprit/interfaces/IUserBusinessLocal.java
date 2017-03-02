package evpro.edu.esprit.interfaces;

import java.util.List;

import javax.ejb.Local;


import evpro.edu.esprit.persistance.User;

@Local
public interface IUserBusinessLocal {

	void ajouterUser(User user);
	
	void modifierUser(User user);
	
	void supprimerUser(User user);

	User chercherUser(Integer id);
	
	User authentificate(String mail, String password);
    
    User findByMail(String mail);
	
	List<User> findAllUsers();
	
	//User chercherUser(Integer id);
}
