package evpro.edu.esprit.business;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import evpro.edu.esprit.interfaces.ITaskBusinessLocal;
import evpro.edu.esprit.interfaces.ITaskBusinessRemote;
import evpro.edu.esprit.persistance.Comment;
import evpro.edu.esprit.persistance.Participant;
import evpro.edu.esprit.persistance.Payment;
import evpro.edu.esprit.persistance.Task;
import evpro.edu.esprit.persistance.TaskPK;
@Stateless
public class TaskBusiness implements ITaskBusinessLocal , ITaskBusinessRemote {
	
	@PersistenceContext(unitName="evpro-ejb")
	EntityManager em;

	public TaskBusiness() {
	}

	@Override
	public void ajouterTask(Task task,TaskPK t) {
		// TODO Auto-generated method stub
		task.setTaskPK(t);
		em.persist(task);
		
	}

	@Override
	public void modifierTask(Task task,TaskPK t) {
		// TODO Auto-generated method stub
		task.setTaskPK(t);
		em.merge(task);
		
	}

	@Override
	public void supprimerTask(Task task,TaskPK t) {
		// TODO Auto-generated method stub
		task.setTaskPK(t);
		em.remove(em.merge(task));
		
	}


	@Override
	public List<Task> findAllOrganizerTasks(Integer id) {
		
		List<Task> Tasks = null;
		String jpql = "select p from Task p where p.orgnizer.idUser=:x ";
		TypedQuery<Task> query = em.createQuery(jpql,Task.class);
		query.setParameter("x", id);
		Tasks = query.getResultList();
		return Tasks;
			
	}

	@Override
	public List<Task> findAllTasks() {
		return em
				.createQuery("select s from Task s", Task.class)
				.getResultList();
	}

	
	

	@Override
	public List<Task> findAllEventTasks(Integer id) {
		
		List<Task> Tasks = null;
		String jpql = "select p from Task p where p.event.idEvent=:x ";
		TypedQuery<Task> query = em.createQuery(jpql,Task.class);
		query.setParameter("x", id);
		Tasks = query.getResultList();
		return Tasks;
				
		
	}
	

	

}
