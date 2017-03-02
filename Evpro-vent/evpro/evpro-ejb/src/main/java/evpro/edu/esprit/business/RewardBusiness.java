package evpro.edu.esprit.business;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import evpro.edu.esprit.interfaces.IRewardBusinessLocal;
import evpro.edu.esprit.interfaces.IRewardBusinessRemote;
import evpro.edu.esprit.persistance.Reward;

@Stateless
public class RewardBusiness implements IRewardBusinessLocal, IRewardBusinessRemote {
	@PersistenceContext(unitName = "evpro-ejb")
	EntityManager em;

	public RewardBusiness() {
		super();
	}

	@Override
	public void ajouterReward(Reward reward) {
		// TODO Auto-generated method stub
		em.persist(em.merge(reward));

	}

	@Override
	public void modifierReward(Reward reward) {
		// TODO Auto-generated method stub
		em.merge(em.merge(reward));

	}

	@Override
	public void supprimerReward(Reward reward) {
		// TODO Auto-generated method stub
		em.remove(em.merge(reward));

	}

	@Override
	public Reward chercherReward(Integer id) {
		// TODO Auto-generated method stub
		return em.find(Reward.class, id);

	}

	@Override
	public boolean rewardExist(int id) {
		TypedQuery<Long> query = em.createQuery("SELECT count  (r) FROM Reward r WHERE r.id=:id ", Long.class)
				.setParameter("id", id);
		long result = query.getSingleResult();
		if (result > 0) {
			return false;
		} else
			return true;

	}

}
