package IT.unipv.progettoM23.Model.persona;

import java.sql.Date;
import java.sql.Time;


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
	
}
		
	

	
	    
	

	    


	

