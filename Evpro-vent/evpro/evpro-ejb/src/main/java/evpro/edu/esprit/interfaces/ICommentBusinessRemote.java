package evpro.edu.esprit.interfaces;

import java.util.List;

import javax.ejb.Remote;

import evpro.edu.esprit.persistance.Comment;
@Remote
public interface ICommentBusinessRemote {
	public void add(Comment comment);
	public Comment find(Integer id);
	public void update(Comment comment);
	public void delete(Comment comment);
	public List<Comment> findAllParticipantComment(Integer id);
	public List<Comment> findAllEventComment(Integer id);
}
