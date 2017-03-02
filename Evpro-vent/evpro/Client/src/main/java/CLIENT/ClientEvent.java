package CLIENT;

import java.io.FileOutputStream;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.hibernate.type.descriptor.java.UUIDTypeDescriptor.ToStringTransformer;
import org.omg.CORBA.Current;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import evpro.edu.esprit.interfaces.IEventBusinessRemote;
import evpro.edu.esprit.interfaces.IMessageBusinessLocal;
import evpro.edu.esprit.interfaces.IMessageBusinessRemote;
import evpro.edu.esprit.interfaces.IOrgnizerBusinessLocal;
import evpro.edu.esprit.interfaces.IOrgnizerBusinessRemote;
import evpro.edu.esprit.interfaces.IParticipantBusinessRemote;
import evpro.edu.esprit.persistance.Event;
import evpro.edu.esprit.persistance.Message;
import evpro.edu.esprit.persistance.Orgnizer;
import evpro.edu.esprit.persistance.Participant;

public class ClientEvent {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();

		String jndiName = "evpro-ear/evpro-ejb/EventBusiness!evpro.edu.esprit.interfaces.IEventBusinessRemote";
		IEventBusinessRemote SALAHPROXY = (IEventBusinessRemote) context.lookup(jndiName);

		// AJOUT EVENT//
		/*
		 * Event e = new Event(); e.setIdEvent(30); e.setCategory("salah");
		 * e.setCityAdress("monastir"); e.setCountryAdress("bouhjar");
		 * e.setDescription("first event"); Date d = new Date(92, 8, 14);
		 * e.setEventFinishingDate(d); e.setEventType("aaaa");
		 * SALAHPROXY.ajouterEvent(e); Event aff = new Event();
		 */
		// ********//

		// AFFICHER EVENT//
		Event aff = new Event();
		List<Event> events = SALAHPROXY.getAllEvents();
		for (int i = 0; i < events.size(); i++) {
			System.out.println("******************");
			System.out.println("Event numero = " + i);
			System.out.println("CityAdress =" + events.get(i).getCityAdress());
			System.out.println("Category =" + events.get(i).getCategory());
			System.out.println("CountryAdress =" + events.get(i).getCountryAdress());
			System.out.println("Description =" + events.get(i).getDescription());
			System.out.println("EventType =" + events.get(i).getEventType());
			System.out.println("FacebookEventLink =" + events.get(i).getFacebookEventLink());
			System.out.println("Laltitude =" + events.get(i).getLaltitude());
			System.out.println("Name =" + events.get(i).getName());
			System.out.println("TwitterEventLink =" + events.get(i).getTwitterEventLink());
			System.out.println("EventFinishingDate =" + events.get(i).getEventFinishingDate());
			System.out.println("IdEvent =" + events.get(i).getIdEvent());
			System.out.println("Longitude =" + events.get(i).getLongitude());
		}
		// *********//

		// DELETE//
		/*
		 * Event e = new Event(); e.setIdEvent(30); e.setCategory("salah");
		 * e.setCityAdress("monastir"); e.setCountryAdress("bouhjar");
		 * e.setDescription("first event"); Date d = new Date(92, 8, 14);
		 * e.setEventFinishingDate(d); e.setEventType("aaaa");
		 * SALAHPROXY.supprimerEvent(e);
		 */
		// ***********//

		// UPDATE//
		/*
		Event e = new Event();
		e.setIdEvent(40);
		e.setCategory("salah");
		e.setCityAdress("monastir");
		e.setCountryAdress("aaaaaaaaaaaaa");
		e.setDescription("first event");
		Date d = new Date(92, 8, 14);
		e.setEventFinishingDate(d);
		e.setEventType("aaaa");
		SALAHPROXY.modifierEvent(e);
		// ***********/
/*
		try {
			for (int m = 0; m< events.size(); m++) {

				String FILE = "C:/Evpro-vent/evpro/Client/PDF/Event-" + events.get(m).getName() + ".pdf";
				Document document = new Document();
				PdfWriter.getInstance(document, new FileOutputStream(FILE));

				document.open();
				Font BLACK = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
				Font RED = new Font(FontFamily.TIMES_ROMAN, 24, Font.BOLD, BaseColor.RED);
				Chunk Name = new Chunk("Name : "+events.get(m).getName(), RED);
				Chunk Category = new Chunk("Category : "+events.get(m).getCategory(), BLACK);
				Chunk CityAdress = new Chunk("City Adress : "+events.get(m).getCityAdress(), BLACK);
				Chunk CountryAdress = new Chunk("Country Adress : "+events.get(m).getCountryAdress(), BLACK);
				Chunk Description = new Chunk("Description : "+events.get(m).getDescription(), BLACK);
				Chunk EventType = new Chunk("Event Type : "+events.get(m).getEventType(), BLACK);
				Chunk FacebookEventLink = new Chunk("Facebook EventLink : "+events.get(m).getFacebookEventLink(), BLACK);
				Chunk Laltitude = new Chunk("Laltitude : "+events.get(m).getLaltitude(), BLACK);
				Chunk Longitude = new Chunk("Longitude : "+events.get(m).getLongitude(), BLACK);
				Chunk Price = new Chunk("Price : "+events.get(m).getPrice(), BLACK);
				Chunk Slogan = new Chunk("Slogan : "+events.get(m).getSlogan(), BLACK);
				Chunk Tag = new Chunk("Tag : "+events.get(m).getTag(), BLACK);
				Chunk TwitterEventLink = new Chunk("Twitter Event Link : "+events.get(m).getTwitterEventLink(), BLACK);
				Chunk Video = new Chunk("Video : "+events.get(m).getVideo(), BLACK);
				Chunk EventFinishingDate = new Chunk("Event Finishing Date : "+events.get(m).getEventFinishingDate(), BLACK);
				Chunk EventStartingDate = new Chunk("Event Starting Date : "+events.get(m).getEventStartingDate(), BLACK);

				Paragraph p1 = new Paragraph(Category);
				Paragraph p2 = new Paragraph(CityAdress);
				Paragraph p3 = new Paragraph(Name);
				Paragraph p4 = new Paragraph(CountryAdress);
				Paragraph p5 = new Paragraph(Description);
				Paragraph p6 = new Paragraph(EventType);
				Paragraph p7 = new Paragraph(FacebookEventLink);
				Paragraph p8 = new Paragraph(Laltitude);
				Paragraph p9 = new Paragraph(Longitude);
				Paragraph p10 = new Paragraph(Price);
				Paragraph p11= new Paragraph(Slogan);
				Paragraph p12 = new Paragraph(Tag);
				Paragraph p13 = new Paragraph(TwitterEventLink);
				Paragraph p14 = new Paragraph(Video);
				Paragraph p15 = new Paragraph(EventFinishingDate);
				Paragraph p16 = new Paragraph(EventStartingDate);

				document.add(p3);
				document.add(p1);
				document.add(p2);
				document.add(p4);
				document.add(p5);
				document.add(p6);
				document.add(p7);
				document.add(p8);
				document.add(p9);
				document.add(p10);
				document.add(p11);
				document.add(p12);
				document.add(p13);
				document.add(p14);
				document.add(p15);
				document.add(p16);
				document.close();
			}

		} catch (Exception A) {
			A.printStackTrace();

		}*/

	}

}
