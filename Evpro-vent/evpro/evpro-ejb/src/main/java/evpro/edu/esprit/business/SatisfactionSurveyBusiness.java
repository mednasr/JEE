package evpro.edu.esprit.business;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import evpro.edu.esprit.interfaces.IEventBusinessLocal;
import evpro.edu.esprit.interfaces.IParticipantBusinessLocal;
import evpro.edu.esprit.interfaces.ISatisfactionSurveyLocal;
import evpro.edu.esprit.interfaces.ISatisfactionSurveyRemote;
import evpro.edu.esprit.persistance.Event;
import evpro.edu.esprit.persistance.Participant;
import evpro.edu.esprit.persistance.SatisfactionSurvey;

@Stateless
@LocalBean
public class SatisfactionSurveyBusiness implements ISatisfactionSurveyLocal,ISatisfactionSurveyRemote {
	private EventBusiness eventbusiness;
	private ParticipantBusiness participantbusiness;
	@PersistenceContext(unitName = "evpro-ejb")
	EntityManager em;

	@EJB
	IParticipantBusinessLocal participantBusinessLocal;
	@EJB
	IEventBusinessLocal eventBusinessLocal;

	@Override
	public void addSatisfactionSurey(SatisfactionSurvey st) {
		// TODO Auto-generated method stub
		em.persist(em.merge(st));
	}

	@Override
	public void RemoveSatisfactionSurvey(SatisfactionSurvey st) {
		// TODO Auto-generated method stub
		em.remove(em.merge(st));
	}

	public long countSurveyPerParticipant(int idParticipant) {
		// TODO Auto-generated method stub

		TypedQuery<Long> query = em
				.createQuery("SELECT COUNT(c) FROM SatisfactionSurvey c where c.idParticipant.idUser=:param",
						Long.class)
				.setParameter("param", idParticipant);
		long SurveysCount = query.getSingleResult();
		return SurveysCount;
	}

	public long countSurveyPerEvent(Integer idEvent) {
		// TODO Auto-generated method stub
		TypedQuery<Long> query = em
				.createQuery("SELECT count  c FROM SatisfactinSurvey c WHERE c.idEvent.idEvent =:idV ", Long.class)
				.setParameter("idV", idEvent);
		long SurveysCount = query.getSingleResult();
		return SurveysCount;
	}

	@Override
	public List<SatisfactionSurvey> FindAllSurveys() {

		List<SatisfactionSurvey> SatisfactionSurvey = (List<SatisfactionSurvey>) em.createQuery(

				"SELECT new SatisfactionSurvey(c.idSurvey,c.creationDate,c.descreptiveText,c.status,c.messageInfo,surveytEvent,"
						+ "surveyParticipant) " + "FROM SatisfactionSurvey c JOIN c.idEvent surveytEvent "
						+ "JOIN c.idParticipant  surveyParticipant",
				SatisfactionSurvey.class).getResultList();

		for (SatisfactionSurvey surv : SatisfactionSurvey) {

			Event surveytEvent = eventBusinessLocal.find(surv.getIdEvent().getIdEvent());
			surv.setIdEvent(surveytEvent);

			Participant surveyParticipant = participantBusinessLocal.find(surv.getIdParticipant().getIdUser());
			surv.setIdParticipant(surveyParticipant);
		}

		return SatisfactionSurvey;

		// surveys = em.createQuery("select s from SatisfactionSurvey
		// s").getResultList();

		// return surveys;
	}

	@Override
	public List<SatisfactionSurvey> FindSurveysByDate(Calendar creationDate) {

		List<SatisfactionSurvey> surveys = null;
		String jpql = "select p from satisfactionsurvey where p.creationDate :=CDate ";
		TypedQuery<SatisfactionSurvey> query = em.createQuery(jpql, SatisfactionSurvey.class);
		query.setParameter("CDate", creationDate);
		surveys = query.getResultList();
		return surveys;

	}

	@Override
	public void DisableFeedBack() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("UPDATE SatisfactionSurvey s SET s.status= :status ");

		q.setParameter("status", false);
		Integer updated = q.executeUpdate();

	}

	@Override
	public void enableFeedBack() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("UPDATE SatisfactionSurvey s SET s.status= :status ");

		q.setParameter("status", true);
		Integer updated = q.executeUpdate();

	}

	public SatisfactionSurveyBusiness() {

	}

	@Override
	public void SendMessageApi(String messageInfo) {
		try {
			String recipient = "+21654061364";
			String message = messageInfo;
			String username = "admin";
			String password = "admin";
			String originator = "06201234567";

			String requestUrl = "http://127.0.0.1:9501/api?action=sendmessage&" + "username="
					+ URLEncoder.encode(username, "UTF-8") + "&password=" + URLEncoder.encode(password, "UTF-8")
					+ "&recipient=" + URLEncoder.encode(recipient, "UTF-8") + "&messagetype=SMS:TEXT" + "&messagedata="
					+ URLEncoder.encode(message, "UTF-8") + "&originator=" + URLEncoder.encode(originator, "UTF-8")
					+ "&serviceprovider=esprit" + "&responseformat=html";

			URL url = new URL(requestUrl);
			HttpURLConnection uc = (HttpURLConnection) url.openConnection();

			System.out.println(uc.getResponseMessage());

			uc.disconnect();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());

		}

	}

	@Override
	public long countAllSurvey() {
		TypedQuery<Long> query = em.createQuery("SELECT count (c.idSurvey) FROM SatisfactionSurvey c", Long.class);

		long AllSurveysCount = query.getSingleResult();
		return AllSurveysCount;
	}

	public int participantResponds() {
		/*
		 * List<Integer> idSEvents =
		 * em.createQuery("SELECT (c.idEvent) FROM Event c",
		 * Integer.class).getResultList(); int countok = 0; int countno = 0; for
		 * (Integer integer : idSEvents) { List<Integer> Survey = em.
		 * createQuery("SELECT t FROM SatisfactionSurvey t where t.idEvent = :value1"
		 * ) .setParameter("value1", idSEvents.get(integer)).getResultList(); }
		 * for (Integer integer : idSEvents) { if (em.
		 * createQuery("SELECT (c.status) FROM SatisfactionSurvey t where t.idEvent = :value1"
		 * ) .setParameter("value1", Survey.get(integer)).getSingleResult() ==
		 * null) { countno++;
		 * 
		 * } else { countok++; } /* TypedQuery<Long> query = em.createQuery(
		 * "SELECT count (c.idSurvey) FROM SatisfactionSurvey c where c.status=:true AND c.idEvent=:idPram "
		 * , Long.class);
		 */
		/*
		 * query.setParameter("idPram", idSEvents.get(i)); long result =
		 * query.getSingleResult(); count.add((int) result);
		 */

		return 1;
	}

}
