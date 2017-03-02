package evpro.edu.esprit.interfaces;

import javax.ejb.Local;

import evpro.edu.esprit.persistance.Reward;

@Local
public interface IRewardBusinessLocal {
	void ajouterReward(Reward msg);

	void modifierReward(Reward reward);

	void supprimerReward(Reward reward);

	Reward chercherReward(Integer id);

	boolean rewardExist(int id);
}
