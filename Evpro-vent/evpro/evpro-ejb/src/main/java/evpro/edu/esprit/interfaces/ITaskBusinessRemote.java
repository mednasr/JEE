package evpro.edu.esprit.interfaces;

import java.util.List;

import javax.ejb.Remote;

import evpro.edu.esprit.persistance.Task;
import evpro.edu.esprit.persistance.TaskPK;

@Remote
public interface ITaskBusinessRemote {

	void ajouterTask(Task task,TaskPK t);

	void modifierTask(Task task,TaskPK t);

	void supprimerTask(Task task,TaskPK t);

	public List<Task> findAllOrganizerTasks(Integer id);
	
	public List<Task> findAllTasks();
	
	public List<Task> findAllEventTasks(Integer id);

}
