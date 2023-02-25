package IT.unipv.progettoM23.persona;

//import java.time.LocalDate;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;

import IT.unipv.progettoM23.CentroNazionaleSangue.Donazione;
import IT.unipv.progettoM23.CentroNazionaleSangue.DonazioneDAO;
import IT.unipv.progettoM23.prenotazioni.Prenotazione;
import IT.unipv.progettoM23.prenotazioni.PrenotazioneDAO;


public class Donatore extends Persona {
    
	private String nome, cognome,sesso;
	
	private Date dob; 
	
	public Donatore(String cf,String c,String n, Date d, String s,GruppoSanguigno g){
		
		super(cf,g);
		this.nome=n;
		this.cognome=c;
        this.sesso=s;
        this.dob=d;
	}
	
	public String getCognome() {
		return this.cognome;
	}
	

	public String getNome() {
		return this.nome;
	}
	
	public Date getData() {
		return this.dob;
	}
	
	public String getSesso() {
		return this.sesso;
	}
	
	public String toString() {
		return this.nome+" "+this.cognome;
	}

	
	
	
	public boolean puòDonare() {
		boolean b = false;
		LocalDate d = LocalDate.now();
		Donazione donazione = null;
		DonazioneDAO dDAO = new DonazioneDAO();
		
		
		donazione = dDAO.selectUltimaDonazione(this);
		
		
		if (donazione == null) {
			return true;
		}
		

		Date data = donazione.getData();
		//LocalDate d1 = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate d1 = data.toLocalDate();

	    
		if (this.getSesso()=="M"){
			
			d1 = d1.plusMonths(3);
			
			if (d1.isBefore(d)) {
				b=  true;
			}
			
			else {
				b = false;
			}
		}
		
		else if (this.getSesso()=="F"){
			d1 = d1.plusMonths(6);
			
			if (d1.isBefore(d)){
				b = true;
			}
			
			else {
				b = false;
			}
			
	    }
		
		return b;
	}
	
	

	
	
	
	public boolean puoPrenotare() {
		PrenotazioneDAO pDAO=new PrenotazioneDAO();
		
		LocalDate today=LocalDate.now();
		
		try {
		    Date dataPren=pDAO.selectUltimaPrenotazione(this.getcodFiscale()).getData();
		
		    LocalDate dataPrenLD = dataPren.toLocalDate();
		    				
		    return today.isAfter(dataPrenLD);
		    //return false;
		}
		
		catch(Exception e) {
			return true;
		}
	}
	
	
	

	
	
//	public Prenotazione creaPrenotazione() {
//		Prenotazione p=null;
//		Date d;
//		Time t;
		
//		LocalDate giornosucc=LocalDate.now().plusDays(1);
//		//LocalDate domani = LocalDate.now().plusDays(1);
//		d = Date.valueOf(giornosucc);
		
//		boolean b=false;
		
		
//		PrenotazioneDAO pd=new PrenotazioneDAO();
		
//		Prenotazione UltimaprenDelGiorno = pd.selectUltimaPrenGiorno(d);
//		Prenotazione PrimaprenDelGiorno = pd.selectPrimaPrenGiorno(d);
		
				
		
//		while (b==false) {  
			
//			if(UltimaprenDelGiorno==null) {
//				t= Time.valueOf("08:00:00");	
//				p=new Prenotazione(this.getcodFiscale(),d, t);
				
//				return p;
//			}
			
//			else if (!PrimaprenDelGiorno.getOra().equals(Time.valueOf("8:00:00")))
//					{
				
//				LocalTime lt=PrimaprenDelGiorno.getOra().toLocalTime();
//				lt =lt.plusMinutes(-30);
				
//				p=new Prenotazione();	
			 
//			return p;
//			}
	    	
//			else if (!UltimaprenDelGiorno.getOra().equals(Time.valueOf("12:30:00"))) {
//	            b=true;
//	        }
	     
//	        else  {
//	            giornosucc = giornosucc.plusDays(1);
//	            d = Date.valueOf(giornosucc);
//	            UltimaprenDelGiorno = pd.selectUltimaPrenGiorno(d);	
	        
//	    }
//	    }
		
//	    	LocalTime lt=UltimaprenDelGiorno.getOra().toLocalTime();
//			lt =lt.plusMinutes(30);
			
//			p=new Prenotazione(this.getcodFiscale(),d, Time.valueOf(lt));	
		
	    
//		return p;
//	}
//}

	
	public Prenotazione creaPrenotazione() {
		Prenotazione p=null;
		Date d;
		Time t;
		Boolean b=false;
		
		LocalDate giornosucc=LocalDate.now().plusDays(1);
		d = Date.valueOf(giornosucc);

		
	    Time primaOra = Time.valueOf("8:00:00");
	    
	    ArrayList<Prenotazione> Prenotazioni = new ArrayList<>();
	    PrenotazioneDAO pd=new PrenotazioneDAO();
	    Prenotazioni = pd.selectDate(d);
	   
	    
	 while (b == false) {
	    	
	    
	    if (Prenotazioni.size() == 0){
	    	p = new Prenotazione(this.getcodFiscale(),d, primaOra);
	    	return p;
	    }
	
	    	
	    else if(Prenotazioni.size()== 10) {
	        giornosucc = giornosucc.plusDays(1);
	    	b=false;	
	    	d = Date.valueOf(giornosucc);
	        Prenotazioni = pd.selectDate(d);
	    	
	    	}
	    
	    	else b = true;
	    }
	    
	
	int i = 1;
	LocalTime lt = LocalTime.of(8, 30);
	Time secondaOra = Time.valueOf(lt);
	boolean c = false; 
	int j = Prenotazioni.size()-1;
	
	while(c==false)
	{
	if(j>=i && Prenotazioni.get(i).getOra().equals(secondaOra)) 
	{
        lt = lt.plusMinutes(30);
		secondaOra = Time.valueOf(lt);
		
		i++;
		c=false;
	}
	else c=true;
	}
	
	return p = new Prenotazione(this.getcodFiscale(),d, secondaOra);
	
	}
	

}
	   
	
	


