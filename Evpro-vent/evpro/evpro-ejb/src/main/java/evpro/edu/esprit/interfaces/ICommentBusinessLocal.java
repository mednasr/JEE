package evpro.edu.esprit.interfaces;

import java.util.Date;
import java.util.List;


import javax.ejb.Local;

import evpro.edu.esprit.persistance.Comment;
import evpro.edu.esprit.persistance.CommentPK;




//@Remote : permet un accès à l'EJB depuis un client hors de la JVM
@Local // permet un accès à l'EJB depuis un client dans la même JVM que celle de l'EJB
public interface ICommentBusinessLocal {
	public void add(Comment comment);
	//public Comment find(CommentPK idComment);
	public void update(Comment comment);
	public void delete(Comment comment);
	public List<Comment> findAllParticipantComment(Integer id);
	public List<Comment> findAllEventComment(Integer id);
	List<Comment> findCommentByDate(Date startDeal);
	
}
