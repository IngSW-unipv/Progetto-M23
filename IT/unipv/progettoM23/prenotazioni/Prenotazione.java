package IT.unipv.progettoM23.prenotazioni;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;

import IT.unipv.progettoM23.CentroNazionaleSangue.Donazione;
import IT.unipv.progettoM23.CentroNazionaleSangue.DonazioneDAO;
import IT.unipv.progettoM23.persona.Donatore;

public class Prenotazione {
	
	private Date data;
	private Time ora;
	private String codFiscale;

	public Prenotazione(String CodFiscale, Date data, Time ora) {
		this.data =data;
		this.ora = ora;
		this.codFiscale=CodFiscale;
		
		
	}
	
	public Time getOra() {
		return this.ora;
	}
	
	public String getCodiceFiscale() {
		return this.codFiscale;
	}
	
	public Date getData() {
		return this.data;
	}

	public String getPrenotazione() { 
	String p;
	p = codFiscale+" "+data+" "+ora;
	return p;
	}
	
	
	public boolean puòDonare(Donatore don) {
		boolean b = false;
		LocalDate d = LocalDate.now();
		Donazione donazione;
		DonazioneDAO dDAO = new DonazioneDAO();
		
		donazione = dDAO.selectUltimaDonazione(don);
		Date data = donazione.getData();
		LocalDate d1 = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	
		if (don.getSesso()=="M")
		{
			
			
			d1 = d1.plusMonths(3);
			if (d1.isBefore(d)) {
				b=  true;
				
			}
			else {
				b = false;
			}
			
		}
		
		else if (don.getSesso()=="F")
		{
			d1 = d1.plusMonths(6);
			
			if (d1.isBefore(d))
			{
				b = true;
			}
			
			else {
				b = false;
					}
			}
		
		
		return b;
			}
	
	
	
	public Prenotazione trovaOrario(Donatore don) {
		Prenotazione p=null;
		Date d;
		Time t;
		
		LocalDate giornosucc=LocalDate.now().plusDays(1);
		//LocalDate domani = LocalDate.now().plusDays(1);
		d = Date.valueOf(giornosucc);
		
		boolean b=false;
		
		
		PrenotazioneDAO pd=new PrenotazioneDAO();
		
		ArrayList<Prenotazione> prenDelGiorno = pd.selectDate(d);
		
	    while (b==false) {
	    	
	        if(	prenDelGiorno.size()!=8) {
	            b=true;
	        }
	     
	        else {
	            giornosucc = giornosucc.plusDays(1);
	            d = Date.valueOf(giornosucc);
	            prenDelGiorno = pd.selectDate(d);	
	        }
	    }
	
	        
		
		if(prenDelGiorno.size()==0){
			t= Time.valueOf("08:00:00");	
			p=new Prenotazione(don.getcodFiscale(),d, t);
			
		}
		
		else {
			
			LocalTime lt=prenDelGiorno.get(-1).getOra().toLocalTime();
			lt =lt.plusMinutes(30);
			
			p=new Prenotazione(don.getcodFiscale(),d, Time.valueOf(lt));	
		}
	    
		return p;
	}
}
		
	

	
	    
	

	    


	

