package IT.unipv.progettoM23.persona;

//import java.time.LocalDate;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

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

	
	
	public Time trovaOrario(Date d) {
		Time p;
		
		PrenotazioneDAO pd=new PrenotazioneDAO();
		
		ArrayList<Prenotazione> prenDelGiorno = pd.selectDate(d);
		
		
		if(prenDelGiorno.size()==8) {
			p=null;
		}
		
		else if(prenDelGiorno.size()==0){
			p= Time.valueOf("08:00:00");		
		}
		
		else {
			
			LocalTime lt=prenDelGiorno.get(-1).getOra().toLocalTime();
			lt =lt.plusMinutes(30);
			
			p= Time.valueOf(lt);
			
		}
		
		return p;
	

	}

}
