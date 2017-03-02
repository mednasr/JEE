package evpro.edu.esprit.business;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import evpro.edu.esprit.interfaces.ICommentBusinessLocal;
import evpro.edu.esprit.persistance.Comment;
import evpro.edu.esprit.persistance.CommentPK;
import evpro.edu.esprit.persistance.Participant;
import evpro.edu.esprit.persistance.Payment;
import evpro.edu.esprit.persistance.Event;
import evpro.edu.esprit.business.ParticipantBusiness;
import evpro.edu.esprit.business.EventBusiness;
@Stateless //c'est le nom de la classe de l'EJB deux clients peuvent acceder a la meme instance
//quant :
//pour assure la rapiditer de lexcution
 @LocalBean  //using @LocalBean and using no annotation at all are both ways of getting a no-interface view
	 public class CommentBusiness implements ICommentBusinessLocal{

	@PersistenceContext(unitName="evpro-ejb") // injecter un gestionnaire d’entités
	private EntityManager em;
	private EventBusiness eventbusiness;
	private ParticipantBusiness participantbusiness;
		public CommentBusiness() {
				// TODO Auto-generated constructor stub
		}

 public void add(Comment comment) {

		em.persist(em.merge(comment));

	}

	/*public Comment findCommentByName(String title) {
		return em.find(Comment.class, title);
	}*/

	public void update(Comment comment) {

		em.merge(comment);

	}

	public void delete(Comment comment) {

		em.remove(em.merge(comment));
	}


		/*public List<Comment> findAllParticipantComment(Integer id) {

		List<Comment> comments = null;
		String jpql = "select c from Comment c where c.participantComments.idUser=:x";
		TypedQuery<Comment> query = em.createQuery(jpql,Comment.class);
		query.setParameter("x", id);
		 return (List<Comment>) query.getResultList();
	}*/

		@SuppressWarnings("unchecked")
	 public List<Comment> findAllComments()
		{
	List<Comment> comment = (List<Comment>) em.createQuery(

			"SELECT new Comment(c.idComment,c.message,participantComments,eventComments) "
			+ "FROM Comment c JOIN c.participantComments participant JOIN c.eventComments event").getResultList();

	for (Comment comments : comment)
		{


			Event event = eventbusiness.find(comments.getEventComments().getIdEvent()); //(EventParticipants.getEvent().getId());
			comments.setEventComments(event); /* A VERIFIER POUR GETALLEVENT WITHOUT BLOCKING THE REST OF DISPLAY */

				Participant participant = participantbusiness.find(comments.getParticipantComments().getIdUser()) ;
				comments.setParticipantComments(participant);
			}

			return comment;
		}

		 public List<Comment> findAllParticipantComment(Integer id) {

		List<Comment> comments = null;
		String jpql = "select c from Comment c where c.participantComments.idUser=:x";
		TypedQuery<Comment> query = em.createQuery(jpql,Comment.class);
		query.setParameter("x", id);
		comments = query.getResultList();
		return comments;
	}

		 @Override
		 public List<Comment> findCommentByDate(Date startComment) {

				List<Comment> Comments = null;
				String jpql = " select c from Comment c where c.date=to_char(StartComment,jj) between date-7 and date+7=:x  ";
				TypedQuery<Comment> query = em.createQuery(jpql,Comment.class);
				query.setParameter("x",startComment);
				Comments = query.getResultList();
				return Comments;
			}

		@Override
		public List<Comment> findAllEventComment(Integer id) {
			// TODO Auto-generated method stub
			return null;
		}

}
