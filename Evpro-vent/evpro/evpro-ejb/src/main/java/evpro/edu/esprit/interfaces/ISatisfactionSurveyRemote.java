package evpro.edu.esprit.interfaces;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Remote;

import evpro.edu.esprit.persistance.SatisfactionSurvey;
@Remote
public interface ISatisfactionSurveyRemote {
	void addSatisfactionSurey (SatisfactionSurvey st);
	void RemoveSatisfactionSurvey (SatisfactionSurvey st);
	long countSurveyPerParticipant (int idParticipant);
	long countAllSurvey  ( );
	long countSurveyPerEvent (Integer idEvent);
	public List<SatisfactionSurvey> FindAllSurveys();
	public List<SatisfactionSurvey> FindSurveysByDate(Calendar creationDate);
	public void DisableFeedBack( );
	public void enableFeedBack( );
	void SendMessageApi(String messageInfo);
	 int participantResponds();

}
