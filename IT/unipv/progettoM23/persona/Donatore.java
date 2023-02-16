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

	
	
	

}
