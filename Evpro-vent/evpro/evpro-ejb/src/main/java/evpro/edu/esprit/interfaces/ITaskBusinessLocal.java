package evpro.edu.esprit.interfaces;

import java.util.List;

import javax.ejb.Local;

import evpro.edu.esprit.persistance.Task;
import evpro.edu.esprit.persistance.TaskPK;

@Local
public interface ITaskBusinessLocal {
	void ajouterTask(Task task,TaskPK t);

	void modifierTask(Task task,TaskPK t);

	void supprimerTask(Task task,TaskPK t);

	public List<Task> findAllOrganizerTasks(Integer id);

	public List<Task> findAllTasks();

	public List<Task> findAllEventTasks(Integer id);

}
