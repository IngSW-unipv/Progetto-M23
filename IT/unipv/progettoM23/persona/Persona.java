package IT.unipv.progettoM23.persona;
//import java.util.ArrayList;

//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

import javax.swing.JFrame;

import com.google.protobuf.TextFormat.ParseException;

//import IT.unipv.progettoM23.database.JavaDatabaseConn;
import IT.unipv.progettoM23.sacche.ControllerSacche;
import Model.ModelCentroDonazioni;
import Model.ModelDonatore;
import controller.ControllerCentroDonazioni;
import controller.ControllerDonatore;
import IT.unipv.progettoM23.CentroNazionaleSangue.Donazione;
import IT.unipv.progettoM23.CentroNazionaleSangue.DonazioneDAO;
import IT.unipv.progettoM23.graphics.CenteredFrame;
import IT.unipv.progettoM23.graphics.DonatorePanel;
import IT.unipv.progettoM23.graphics.LoginPanel;
//import IT.unipv.progettoM23.graphics.LoginPanel;
//import IT.unipv.progettoM23.graphics.registrazine.RegistrationPanel;
// import IT.unipv.progettoM23.graphics.CenteredFrame;
import IT.unipv.progettoM23.prenotazioni.Prenotazione;
import IT.unipv.progettoM23.prenotazioni.PrenotazioneDAO;


//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.Container;
import java.sql.Date;
import java.sql.Time;
//import java.sql.Driver;

public class Persona {
    
	private String codFiscale;
	private GruppoSanguigno gruppo;
 
	
	
	public Persona( String cf, GruppoSanguigno g) {
//		this.nome=n;
//		this.cognome=c;
		this.codFiscale=cf;
//		this.sesso=s;
		this.gruppo=g;
//		this.dob=d;

		
	}

	
	public String getcodFiscale() {
		return this.codFiscale;
	}

	
	
	public GruppoSanguigno getGruppo() {
		return this.gruppo;
	}
	
	
	public static class MappaGruppi {
		
		private final HashMap<GruppoSanguigno, GruppoSanguigno[] > mappaGruppi = new HashMap<GruppoSanguigno, GruppoSanguigno[] >();
		
		
		public MappaGruppi() {
			
			GruppoSanguigno[] donatoriA = {GruppoSanguigno.A,GruppoSanguigno.ZERO};
			mappaGruppi.put(GruppoSanguigno.A, donatoriA);
			
			GruppoSanguigno[] donatoriB = {GruppoSanguigno.B,GruppoSanguigno.ZERO};
			mappaGruppi.put(GruppoSanguigno.B, donatoriB);
			
			GruppoSanguigno[] donatoriAB = {GruppoSanguigno.A,GruppoSanguigno.B,GruppoSanguigno.AB,GruppoSanguigno.ZERO};
			mappaGruppi.put(GruppoSanguigno.AB, donatoriAB);
			
			GruppoSanguigno[] donatori0 = {GruppoSanguigno.ZERO};
			mappaGruppi.put(GruppoSanguigno.ZERO, donatori0);
		}
		
		
		public GruppoSanguigno[] chiDonaA(GruppoSanguigno g) {	
			return this.mappaGruppi.get(g);	
		}
		
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {

//		MappaGruppi pr = new MappaGruppi();
		
//		System.out.println(pr.chiDonaA(GruppoSanguigno.A)[1]);
		
//		DonatoreDAO s = new DonatoreDAO();
//	    String cf = "OOOOOOOOOOOOOOOO";
//		s.selectDonatore(cf);
//	    ArrayList<Donatore> d = s.selectAll();
	    
//	    System.out.println(d.get(0));
	    
//		PrenotazioneDAO p = new PrenotazioneDAO();         
//		Date e = new Date(2023-01-19);
//        ArrayList<Prenotazione> n = p.selectDate(e);
	    
//	    System.out.println(n.get(0));
//	    System.out.println(n.get(1));
//	    System.out.println(n.get(2));
	    
	    
//	    ControllerSacche cntr = new ControllerSacche() ;
//	    System.out.println(cntr.getNumSacche(GruppoSanguigno.A));
	    
//	    java.util.Date currentDate =GregorianCalendar.getInstance().getTime();    
//	    DateFormat df = DateFormat.getDateInstance();
//	    String dateString = df.format(currentDate);
//	    System.out.println(dateString);
	    
//	    DonatoreDAO don = new DonatoreDAO();
//	    String cf1 = "TTTFFF000UUU333A";
//	    Persona d1 = don.selectDonatore(cf1);
//	    System.out.println(d1.getCognome());
	    
	    
       CenteredFrame cf= new CenteredFrame(800,600); 
	   
	    //cf.showView("utente");
	    
	    
	    //Donatore donatore = new Donatore ("TTTTTTTTTTTTTTTT","ROSSI", "MARIO",Date.valueOf("2001-01-01") ,"M", GruppoSanguigno.ZERO );
	    //System.out.println(donatore.puoPrenotare());
	    
	    ModelDonatore model =new ModelDonatore();
	    ControllerDonatore cntr =new ControllerDonatore(cf,model);
       
       //ModelCentroDonazioni model =new ModelCentroDonazioni();
       //ControllerCentroDonazioni controller = new ControllerCentroDonazioni(cf, model);
		
//		Date d2= Date.valueOf("2001-01-01");
//		Donatore donatore = new Donatore ("TTTTTTTTTTTTTTTT","ROSSI", "MARIO",d2 ,"M", GruppoSanguigno.ZERO );
//		DonatorePanel dp =new DonatorePanel(donatore);
//		cf.add(dp);
		
		//ControllerLoginPanel clp = new ControllerLoginPanel();
		//LoginPanel lp = new LoginPanel(clp);
		//cf.add(lp);
//	    DonazioneDAO d1 = new DonazioneDAO();
//      ArrayList<Donazione> d3 = d1.selectDonazioni(donatore.getcodFiscale());
		
//		PrenotazioneDAO p = new PrenotazioneDAO();
///		Prenotazione p1;
//		p1 = p.selectUltimaPrenotazione(donatore.getcodFiscale());
//		System.out.println(p1.getData());
		
		
//		RegistrationPanel lp=new RegistrationPanel();
		
//		Container c=cf.getContentPane();
		
//		c.add(lp);
	   
	    
//	    PrenotazioneDAO p1 = new PrenotazioneDAO(); 

        
//          Date e = new Date(123,00,01);
//          Date e = Date.valueOf("2023-01-01");
//    	    System.out.println(e);
//          ArrayList<Prenotazione> n = p1.selectDate(e);
//          Prenotazione n1 = n.get(0);
//          System.out.println(n1.getPrenotazione());
//          Prenotazione n2 = n.get(1);
//          System.out.println(n2.getPrenotazione());
//          Prenotazione n3 = n.get(2);
//          System.out.println(n3.getPrenotazione());
//          Prenotazione n4 = n.get(3);
//          System.out.println(n4.getPrenotazione());
          
//          Date o = Date.valueOf("2023-02-02");
//          Time t = Time.valueOf("16:30:00");
//          p1.inserisciPrenotazione(new Prenotazione("TTTTTTTTT5566778",o,t ));
          
//          ArrayList<Prenotazione> v = p1.selectDate(o);
//          Prenotazione v1 = v.get(0);
//          System.out.println(v1.getPrenotazione());
        
      //    s.inserisciDonatore(new Donatore("TTTTTTTTT5566778", "VERDI","GABRIELE",e,"M", GruppoSanguigno.B));
          
		
//		LoginRegistrazione l = new LoginRegistrazione("AAAAAAAAAAAAAAAA", "12345678");
//		LoginRegistrazioneDAO ld = new LoginRegistrazioneDAO();
		
//		System.out.println(ld.verificaUtente(l));

//        ld.verificaCodiceFiscale(l.getCodiceFiscale());
//        System.out.println(ld.verificaCodiceFiscale(l.getCodiceFiscale()));
	
//		System.out.println(ld.inserisciUtente(l));
//		ld.verificaUtente(l);
//		Date d1 = Date.valueOf("2023-01-02");
//		Donatore donatore = new Donatore ("DDDDDDDDDDDDDDDD","ROSSI", "MARIO",d1 ,"M", GruppoSanguigno.ZERO );
	//	Donazione donazione = new Donazione(donatore.getcodFiscale(), d1 );
	//	DonazioneDAO donazioneDAO = new DonazioneDAO();
//		donazioneDAO.inserisciDonazione(donazione);
	    
	//    DonatoreDAO donat = new DonatoreDAO();
	//  donat.selectDonatore("DDDDDDDDDDDDDDDD");
	    
	//  PrenotazioneDAO prenDao = new PrenotazioneDAO();
	 // Prenotazione pren = new Prenotazione("TTTTTTTTTTTTTTTT", Date.valueOf("2023-01-01"), Time.valueOf("9:30:00"));
	    
	 // prenDao.inserisciPrenotazione(pren);
	//  prenDao.cancellaPrenotazione(pren); 
	    
	 // LoginRegistrazioneDAO lrDAO = new LoginRegistrazioneDAO();
	//   LoginRegistrazione lr = new LoginRegistrazione("VVVVVVVVVVVVVVVV", "1234567");
	//   lrDAO.inserisciUtente(lr);
	   
	//   Donatore donatore = new Donatore("VVVVVVVVVVVVVVVV", "VVVVVVVVVVVVVVVV", "GIOVANNI", Date.valueOf("2002-01-03"), "M", GruppoSanguigno.AB);
	//   donat.inserisciDonatore(donatore);
	   
	    
//	    DonazioneDAO donazioneDAO = new DonazioneDAO();
//	    donazioneDAO.selectUltimaDonazione(donatore);
		
	}
	
}
