package evpro.edu.esprit.interfaces;
import javax.ejb.Remote;

import evpro.edu.esprit.persistance.Reward;

@Remote
public interface IRewardBusinessRemote {
void ajouterReward(Reward reward);
	
	void modifierReward(Reward reward);
	
	void supprimerReward(Reward  reward);
	
	Reward chercherReward(Integer id);

}
